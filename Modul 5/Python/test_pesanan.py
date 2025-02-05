import pytest
from unittest.mock import MagicMock, patch
from pesanan import (
    load_from_docx, save_to_docx, create_pesanan,
    read_pesanan, update_pesanan, delete_pesanan, search_pesanan
)
import os

@pytest.fixture
def sample_pesanan():
    return [
        {"id": 1, "nama": "Alice", "menu": "Nasi Goreng", "jumlah": 2, "status": "diproses", "image": ""}, 
        {"id": 2, "nama": "Bob", "menu": "Mie Ayam", "jumlah": 1, "status": "selesai", "image": ""}
    ]

# Mock Document and file existence for load_from_docx and save_to_docx
def test_load_from_docx(monkeypatch):
    mock_document = MagicMock()
    mock_paragraphs = [
        MagicMock(text="ID Pesanan: 1"),
        MagicMock(text="Nama Pelanggan: Alice"),
        MagicMock(text="Menu Pesanan: Nasi Goreng"),
        MagicMock(text="Jumlah: 2"),
        MagicMock(text="Status: diproses"),
        MagicMock(text="Image Path: "),
        MagicMock(text="-" * 40),
    ]
    mock_document.paragraphs = mock_paragraphs

    monkeypatch.setattr("pesanan.Document", MagicMock(return_value=mock_document))
    monkeypatch.setattr("os.path.exists", lambda x: True)

    result = load_from_docx()
    expected = [
        {"id": 1, "nama": "Alice", "menu": "Nasi Goreng", "jumlah": 2, "status": "diproses", "image": ""}
    ]
    assert result == expected

@patch("pesanan.Document")
@patch("os.path.exists")
def test_save_to_docx(mock_exists, mock_document, sample_pesanan):
    mock_exists.return_value = True
    mock_doc = MagicMock()
    mock_document.return_value = mock_doc

    save_to_docx(sample_pesanan)

    mock_doc.add_heading.assert_called_once_with('Manajemen Pesanan Restoran', 0)
    mock_doc.add_paragraph.assert_any_call("ID Pesanan: 1")
    mock_doc.save.assert_called_once_with(os.path.join(os.getcwd(), "pesanan_restoran.docx"))

# Mocking input and output for create_pesanan
def test_create_pesanan(monkeypatch, sample_pesanan):
    inputs = iter(["Charlie", "Ayam Bakar", "3", "", "1"])
    monkeypatch.setattr("builtins.input", lambda _: next(inputs))

    mock_save = MagicMock()
    monkeypatch.setattr("pesanan.save_to_docx", mock_save)

    create_pesanan(sample_pesanan)
    assert len(sample_pesanan) == 3
    assert sample_pesanan[-1]["nama"] == "Charlie"
    assert sample_pesanan[-1]["status"] == "diproses"
    mock_save.assert_called_once()

# Mocking output for read_pesanan
def test_read_pesanan(monkeypatch, capsys, sample_pesanan):
    read_pesanan(sample_pesanan)
    captured = capsys.readouterr()
    assert "ID Pesanan: 1" in captured.out
    assert "Nama Pelanggan: Alice" in captured.out

# Mocking input for update_pesanan
def test_update_pesanan(monkeypatch, sample_pesanan):
    inputs = iter(["1", "selesai"])
    monkeypatch.setattr("builtins.input", lambda _: next(inputs))

    mock_save = MagicMock()
    monkeypatch.setattr("pesanan.save_to_docx", mock_save)

    update_pesanan(sample_pesanan)
    assert sample_pesanan[0]["status"] == "selesai"
    mock_save.assert_called_once()

# Mocking input for delete_pesanan
def test_delete_pesanan(monkeypatch, sample_pesanan):
    inputs = iter(["2"])  # ID pesanan yang valid
    monkeypatch.setattr("builtins.input", lambda _: next(inputs))

    mock_save = MagicMock()
    monkeypatch.setattr("pesanan.save_to_docx", mock_save)

    delete_pesanan(sample_pesanan)
    assert len(sample_pesanan) == 1  # Pastikan hanya satu pesanan yang tersisa
    assert sample_pesanan[0]["id"] == 1  # ID pesanan pertama tetap ada
    mock_save.assert_called_once()

# Mocking input and output for search_pesanan
def test_search_pesanan(monkeypatch, capsys, sample_pesanan):
    inputs = iter(["Alice"])
    monkeypatch.setattr("builtins.input", lambda _: next(inputs))

    search_pesanan(sample_pesanan)
    captured = capsys.readouterr()
    assert "ID Pesanan: 1" in captured.out
    assert "Nama Pelanggan: Alice" in captured.out

# Repeated tests for robustness
def test_repeated_create_pesanan(monkeypatch, sample_pesanan):
    for i in range(10):
        inputs = iter([f"Customer{i}", f"Menu{i}", str(i + 1), "", "1"])
        monkeypatch.setattr("builtins.input", lambda _: next(inputs))

        mock_save = MagicMock()
        monkeypatch.setattr("pesanan.save_to_docx", mock_save)

        create_pesanan(sample_pesanan)
        assert sample_pesanan[-1]["nama"] == f"Customer{i}"
        assert sample_pesanan[-1]["menu"] == f"Menu{i}"
        mock_save.assert_called()

# Test case for empty document when loading data
def test_load_from_empty_docx(monkeypatch):
    mock_document = MagicMock()
    mock_document.paragraphs = []

    monkeypatch.setattr("pesanan.Document", MagicMock(return_value=mock_document))
    monkeypatch.setattr("os.path.exists", lambda x: True)

    result = load_from_docx()
    assert result == []  # No data should be loaded

# Test case for a file that doesn't exist
@patch("pesanan.Document")
@patch("os.path.exists")
def test_load_from_nonexistent_file(mock_exists, mock_document):
    mock_exists.return_value = False

    result = load_from_docx()
    assert result == []  # If the file doesn't exist, return an empty list

# Test case for edge case when there is only one order
def test_create_pesanan_edge_case(monkeypatch, sample_pesanan):
    inputs = iter(["Dave", "Mie Goreng", "1", "", "1"])
    monkeypatch.setattr("builtins.input", lambda _: next(inputs))

    mock_save = MagicMock()
    monkeypatch.setattr("pesanan.save_to_docx", mock_save)

    # Sebelum test, hanya ada 2 pesanan
    create_pesanan(sample_pesanan)
    assert len(sample_pesanan) == 3  # Pastikan ada 3 pesanan setelah penambahan
    assert sample_pesanan[-1]["nama"] == "Dave"
    assert sample_pesanan[-1]["status"] == "diproses"
    mock_save.assert_called_once()

# Test case for updating an order with invalid ID
def test_update_pesanan_invalid_id(monkeypatch, sample_pesanan):
    inputs = iter(["999", "selesai"])  # Invalid ID
    monkeypatch.setattr("builtins.input", lambda _: next(inputs))

    mock_save = MagicMock()
    monkeypatch.setattr("pesanan.save_to_docx", mock_save)

    # No update should occur as the ID doesn't exist
    update_pesanan(sample_pesanan)
    assert sample_pesanan[0]["status"] == "diproses"  # Status shouldn't change
    mock_save.assert_not_called()  # save shouldn't be called

# Test case for searching with no matching records
def test_search_pesanan_no_match(monkeypatch, capsys, sample_pesanan):
    inputs = iter(["NonexistentName"])
    monkeypatch.setattr("builtins.input", lambda _: next(inputs))

    search_pesanan(sample_pesanan)
    captured = capsys.readouterr()
    assert "Pesanan tidak ditemukan." in captured.out  # Ensure proper message when no match

# Test case for saving the document when there are no pesanan
def test_save_to_docx_empty_list(mock_exists, mock_document):
    mock_exists.return_value = True
    mock_doc = MagicMock()
    mock_document.return_value = mock_doc

    save_to_docx([])  # Empty list passed

    mock_doc.add_heading.assert_called_once_with('Manajemen Pesanan Restoran', 0)
    mock_doc.save.assert_called_once_with(os.path.join(os.getcwd(), "pesanan_restoran.docx"))
    mock_doc.add_paragraph.assert_not_called()  # No pesanan should result in no paragraphs added
