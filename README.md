# Malenia - Task Management Chatbot

Malenia is a lightweight, Object-Oriented Command Line Interface (CLI) task management application written in Java. It acts as a personal chatbot assistant to help users track different types of tasks, search through them, and automatically save progress locally.

## Features
* **Manage 3 Task Types**: Supports basic `ToDos`, `Deadlines` (with due dates), and `Events` (with start and end times).
* **Task Operations**: Easily add, delete, mark as done, or unmark tasks.
* **Search Functionality**: Quickly find specific tasks using a keyword.
* **Persistent Storage**: Automatically saves your task list to your local hard drive (`./data/maleniaTaskList.txt`) and loads it the next time you boot up.
* **Robust Error Handling**: Prevents crashes from accidental typos or missing parameters.

---

## Getting Started

### Prerequisites
1. Ensure that you have Java 17 or above installed.
2. Download the latest malenia.jar from the Releases page.

### Running the Application
1. Open a terminal in the same directory as malenia.jar
2. Run:
java -jar malenia.jar

3. The chatbot will greet you and wait for your command!

---

## Command Usage Guide

Malenia responds to specific commands. Words in `<brackets>` represent the parameters you need to provide.

### 1. Adding Tasks

**Todo**
Adds a basic task with no specific date attached.
* **Format:** `todo <description>`
* **Example:** `todo read a book`

**Deadline**
Adds a task that needs to be completed by a specific date or time.
* **Format:** `deadline <description> /by <due_date>`
* **Example:** `deadline submit assignment /by Sunday 2359`

**Event**
Adds an event that spans a specific duration.
* **Format:** `event <description> /from <start_time> /to <end_time>`
* **Example:** `event project meeting /from 2pm /to 4pm`

### 2. Managing Tasks

**List**
Displays all the tasks currently in your list, along with their index numbers and current marked status.
* **Format:** `list`

**Mark**
Marks a specific task in your list as completed (represented by `[X]`).
* **Format:** `mark <task_number>`
* **Example:** `mark 1` *(Marks the 1st task in the list as done)*

**Unmark**
Marks a completed task as not done yet (represented by `[ ]`).
* **Format:** `unmark <task_number>`
* **Example:** `unmark 1`

**Delete**
Permanently removes a task from your list based on its index number.
* **Format:** `delete <task_number>`
* **Example:** `delete 3` *(Removes the 3rd task from the list)*

### 3. Searching

**Find**
Searches your entire task list for any tasks that contain a specific keyword. 
*Note: The find command only accepts a single keyword and only full words will be matched*
* **Format:** `find <single_keyword>`
* **Example:** `find paper` will match with `paper` but not `papercut`

### 4. Exiting

**Bye**
Saves your current task list to the hard drive and exits the application safely.
* **Format:** `bye`

---

## Data Storage
Your data is automatically saved into a text file located at `./data/maleniaTaskList.txt`. You do not need to manually create this file or folder; Malenia will generate it for you upon your first save.

## Author
* **Alexander Yaw Kai Mun**