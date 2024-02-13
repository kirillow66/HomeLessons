function addTask() {
    var taskInput = document.getElementById('taskInput');
    var taskList = document.getElementById('taskList');

    if (taskInput.value) {
        var listItem = document.createElement('li');
        var checkbox = document.createElement('input');
        checkbox.type = 'checkbox';
        var taskText = document.createTextNode(taskInput.value);
        var deleteButton = document.createElement('button');
        deleteButton.innerHTML = 'Delete';

        listItem.appendChild(checkbox);
        listItem.appendChild(taskText);
        listItem.appendChild(deleteButton);

        taskList.appendChild(listItem);

        taskInput.value = '';

        deleteButton.onclick = function() {
            taskList.removeChild(listItem);
        };
    }
}