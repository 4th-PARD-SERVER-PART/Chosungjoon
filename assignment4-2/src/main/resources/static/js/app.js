const apiUrl = 'http://localhost:8080/api/items'; // Replace with your actual API URL
const contentDiv = document.getElementById('content');
const itemForm = document.getElementById('itemForm');
const itemModal = new bootstrap.Modal(document.getElementById('itemModal'));
const errorAlert = document.getElementById('errorAlert');
let isEditMode = false;
let editingItemId = null;

// Function to show an error message
function showError(message) {
    errorAlert.textContent = message;
    errorAlert.style.display = 'block';
}

// Function to hide error message
function hideError() {
    errorAlert.style.display = 'none';
}

// Load items from the API
async function loadItems() {
    try {
        const response = await fetch(apiUrl);
        if (!response.ok) throw new Error('Failed to fetch items');
        const items = await response.json();
        displayItems(items);
        hideError();
    } catch (error) {
        console.error('Error loading items:', error);
        showError('Error loading items. Please try again later.');
    }
}

// Display items in the content div
function displayItems(items) {
    contentDiv.innerHTML = items.map(item => `
        <div class="card my-2">
            <div class="card-body">
                <h5 class="card-title">${item.name ?? 'Unnamed Item'}</h5>
                <p class="card-text">${item.description ?? 'No description available'}</p>
                <p class="card-text">Price: $${item.price ?? 'N/A'}</p>
                <p class="card-text">Quantity: ${item.quantity ?? 'N/A'}</p>
                <button class="btn btn-warning" onclick="showEditModal('${item.id}', '${item.name}', '${item.description}', '${item.price}', '${item.quantity}')">Edit</button>
                <button class="btn btn-danger" onclick="deleteItem('${item.id}')">Delete</button>
            </div>
        </div>
    `).join('');
}

// Show the modal for adding a new item
function showAddModal() {
    itemForm.reset();
    editingItemId = null;
    isEditMode = false;
    hideError();
    itemModal.show();
}

// Show the modal for editing an existing item
function showEditModal(id, name, description, price, quantity) {
    document.getElementById('itemName').value = name ?? '';
    document.getElementById('itemDescription').value = description ?? '';
    document.getElementById('itemPrice').value = price ?? '';
    document.getElementById('itemQuantity').value = quantity ?? '';
    editingItemId = id;
    isEditMode = true;
    hideError();
    itemModal.show();
}

// Handle form submission for adding or updating items
itemForm.addEventListener('submit', async (event) => {
    event.preventDefault();

    const itemData = {
        name: document.getElementById('itemName').value || null,
        description: document.getElementById('itemDescription').value || null,
        price: parseFloat(document.getElementById('itemPrice').value) || null,
        quantity: parseInt(document.getElementById('itemQuantity').value) || null
    };

    try {
        if (isEditMode && editingItemId) {
            await updateItem(editingItemId, itemData);
        } else {
            await createItem(itemData);
        }
        itemModal.hide();
        loadItems();
    } catch (error) {
        console.error('Error submitting form:', error);
        showError('Error saving item. Please try again.');
    }
});

// Create a new item
async function createItem(itemData) {
    const response = await fetch(apiUrl, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(itemData)
    });
    if (!response.ok) throw new Error('Failed to create item');
}

// Update an existing item
async function updateItem(id, itemData) {
    const response = await fetch(`${apiUrl}/${id}`, {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(itemData)
    });
    if (!response.ok) throw new Error('Failed to update item');
}

// Delete an item with confirmation
async function deleteItem(id) {
    const confirmDelete = confirm("Are you sure you want to delete this item?");
    if (!confirmDelete) return;

    try {
        const response = await fetch(`${apiUrl}/${id}`, { method: 'DELETE' });
        if (!response.ok) throw new Error('Failed to delete item');
        loadItems();
    } catch (error) {
        console.error('Error deleting item:', error);
        showError('Error deleting item. Please try again.');
    }
}

// Initialize by loading items
loadItems();
