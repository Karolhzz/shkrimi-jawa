<template>
    <div class="row" >
        <img :src="logo" alt="Logotipo del ejemplo">
        <h1>{{titulo}}</h1>

    </div>
</template>


<script>

export default{
    data() {
        return{
            titulo:"Prueba de encabezado",
            logo:"https://www.ejemplos.co/wp-content/uploads/2015/11/Logo-Adidas.jpg"

        }
    }
    }



</script>


<style scoped>
</style>