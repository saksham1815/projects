let tasks = [];

function addTask() {
    const taskInput = document.getElementById("taskInput");
    const taskText = taskInput.value.trim();
    if (taskText !== "") {
        tasks.push({ text: taskText, checked: false });
        renderTasks();
        taskInput.value = "";
    } else {
        alert("Please enter a task!");
    }
}

function removeTask(index) {
    tasks.splice(index, 1);
    renderTasks();
}

function toggleCheck(index) {
    tasks[index].checked = !tasks[index].checked;
    renderTasks();
}

function renderTasks() {
    const taskList = document.getElementById("taskList");
    taskList.innerHTML = "";
    tasks.forEach((task, index) => {
        const listItem = document.createElement("li");
        listItem.innerHTML = `
            <input type="checkbox" ${task.checked ? 'checked' : ''} onchange="toggleCheck(${index})">
            <span class="task-text ${task.checked ? 'checked' : ''}">${task.text}</span>
            <span class="close" onclick="removeTask(${index})">&times;</span>
        `;
        taskList.appendChild(listItem);
    });
}
