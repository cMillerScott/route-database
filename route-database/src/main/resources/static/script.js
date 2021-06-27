function deleteAreaConfirm(){
    let editForm = document.getElementById("editForm");

    let del = confirm("Removing this area will also remove this area's routes!\n\nAre you sure you want to proceed?");
        if(del == false) {
            editForm.onsubmit = event.preventDefault();
        }
    }


function deleteRouteConfirm(){
     let editForm = document.getElementById("editForm");

     let del = confirm("Area you sure you want to remove this route?");
         if(del == false) {
             editForm.onsubmit = event.preventDefault();
         }
     }