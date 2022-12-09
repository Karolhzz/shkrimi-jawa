<template>
    <div class="row" >
        <div class="col-md8">
            <Home/>
        </div>
        <div col-md4>
            <Lateral/>
        </div>
<h3>HOMEVIEW</h3>
    </div>
</template>


<script>

import Home from '../components/Home.vue';
import Lateral from '../components/Lateral.vue';

export default{
    
    components: { Home, Lateral },
}

</script>


<style scoped>
</style>