const getAllCategory = () => {
   return $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type:"GET",
        url: "http://localhost:8080/api/categories",
    })
} 
