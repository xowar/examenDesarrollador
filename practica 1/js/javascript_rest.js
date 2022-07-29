//Asigna la case en el elemento HTML para mostra los resultados
const aplicacion = document.querySelector('.app')

const url = 'https://my-json-server.typicode.com/dp-danielortiz/dptest_jsonplaceholder/items'

fetch(url)
.then(res => res.json())
.then(data => {		
	for (let index = 0; index < data.length; index++) {
		//Si el valor de color es diferente a red eliminara el elemento
		if (data[index].color !== 'red') {
			delete data[index];		
		}
	}
	//Imprime los datos en HTML por cada elemento que contenga color:red
	data.forEach(item => {
		const par = document.createElement("p")
		par.innerText = 'Id: '+item.id 
		aplicacion.appendChild(par)
		
		const par2 = document.createElement("p")
		par2.innerText = 'Tipo: '+item.type
		aplicacion.appendChild(par2)

		const par3 = document.createElement("p")
		par3.innerText = 'Color: '+item.color
		aplicacion.appendChild(par3)
		
	});
})	



