function processConfirm(){
    let editForm = document.getElementById("editForm");

    let del = confirm("Removing this area will also remove the area's routes!\nAre you sure you want to proceed?");
        if(del == false) {
            editForm.onsubmit = event.preventDefault();
        }
    }