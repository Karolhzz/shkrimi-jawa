<template>
    <div class="container">
        <div class="row">
        <div class="col-md-12">
            
        <Encabezado /> 
        </div>
        </div>

        <div class="row">
            <ul class="nav">
            <li class="nav-item">

            <RouterLink class="nav-link active" to="/">Home</RouterLink>
            </li>
            <li class="nav-item">
            <RouterLink class="nav-link" to="/persona"> Persona</RouterLink></li>
            <li class="nav-item">
            <RouterLink class="nav-link " to="/ciudad">Ciudad</RouterLink>
            </li>
            </ul>
        </div>

        <div class="row contenido">
            <RouterView />
         </div>

        <div class="row">
            
            <Pie/>
        </div>
    </div>

    </template>



    <script>
    import { RouterLink, RouterView } from 'vue-router';

    import Encabezado from './components/Encabezado.vue';
    import Pie from './components/Pie.vue';
  

    export default{
    components: { Encabezado, Pie },
    data() {
        return{
            mensaje:"hola mundo",
        }
    }
    }


    
    </script>



    <style scoped>
    .contenido {
    padding: 12px;
    border: 1px solid #ccc;
    border-radius: 8px;
    min-height: 550px;
    }
    </style>