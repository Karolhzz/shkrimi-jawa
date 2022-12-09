<template>
    <div class="container">
        <h1>{{ texto }}</h1>
        <div id="formularioPersona">

            <div class="mb-3">
                <label for="id" class="form-label">ID</label>
                <input v-model="id" type="number" class="form-control" id="id" placeholder="Digite el Id">
            </div>
            <div class="mb-3">
                <label for="nombre" class="form-label">Nombre</label>
                <input v-model="nombre" type="text" class="form-control" id="nombre" placeholder="Digite el nombre">
            </div>
            <div class="mb-3">
                <label for="apellido" class="form-label">Apellido</label>
                <input v-model="apellido" type="text" class="form-control" id="apellido"
                    placeholder="Digite el apellido">
            </div>
            <div class="mb-3">
                <label for="correoElectronico" class="form-label">Correo Electrónico</label>
                <input v-model="correoElectronico" type="email" class="form-control" id="correoElectronico"
                    placeholder="name@example.com">
            </div>
            <div class="mb-3">
                <label for="telefono" class="form-label">Telefono</label>
                <input v-model="telefono" type="number" class="form-control" id="telefono"
                    placeholder="Digite el telefono">
            </div>

            <button v-on:click="crearPersona">crear</button>
        </div>

        <div id="consultaPersona">
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Apellido</th>
                        <th scope="col">Correo Electronico</th>
                        <th scope="col">Telefono</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="persona in personas">
                    <td>{{persona.id}}</td>
                    <td>{{persona.nombre}}</td>
                    <td>{{persona.apellido}}</td>
                    <td>{{persona.correoElectronico}}</td>
                    <td>{{persona.telefono}}</td>
                    </tr>
                </tbody>
            </table>

        </div>
    </div>
</template>


<script>


export default {
    data() {
        return {
            texto: "persona",
            url: "http://localhost:8080/api/personas",
            id: 0,
            nombre: "",
            apellido: "",
            correoElectronico: "",
            telefono: 0,
            personas: []
        }
    },

    methods: {
        limpiarFormulario(){
            this.id= 0;
            this.nombre= "";
            this.apellido= "";
            this.correoElectronico="";
            this.telefono= 0;
        },
        
        
        consultarPersona() {
            const opciones =
            {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': 'Basic dXNlcjpodHRwOi8vbG9jYWxob3N0OjgwODAvYXBpL3BlcnNvbmFz'
                }
            };

            fetch(this.url, opciones).then(async (response) => {
                if (response.ok) {
                    this.personas = await response.json();
                    console.log(this.personas);
                    

                } else {
                    const error = new Error(response.statusText);
                    error.json = response.json();
                    console.log(error.message);
                    throw error;
                }
            })
        },
        crearPersona() {
            const opciones =
            {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': 'Basic dXNlcjpodHRwOi8vbG9jYWxob3N0OjgwODAvYXBpL3BlcnNvbmFz'
                },
                body: JSON.stringify({
                    id: this.id,
                    nombre: this.nombre,
                    apellido: this.apellido,
                    correoElectronico: this.correoElectronico,
                    telefono: this.telefono,

                })
            };
            fetch(this.url, opciones).then(async (response) => {
                if (response.ok) {
                    const data = await response.json();
                    console.log(data);
                    this.limpiarFormulario();
                    this.consultarPersona();

                } else {
                    const error = new Error(response.statusText);
                    error.json = response.json();
                    console.log(error.message);
                    throw error;
                }
            })

        }




    },
    beforeMount() {
        this.consultarPersona();
    }

}

</script>


<style scoped>

</style>