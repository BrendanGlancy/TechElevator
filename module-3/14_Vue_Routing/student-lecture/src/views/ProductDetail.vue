<!-- ProductDetail router view component--> 
<template>
<div id='app' class='main'>
    <h1>{{ product.name }}</h1>  <!-- get the name for the product selected-->
    <p class='description'>{{product.description}}</p>
    <div class="actions">
        <router-link v-bind:to="{name: 'products'}">Back to Products</router-link>
    </div>
    <div class='well-display'>   <!-- display count of each rating -->
        <average-summary />
        <star-summary rating='1' />
        <star-summary rating='2' />
        <star-summary rating='3' />
        <star-summary rating='4' />
        <star-summary rating='5' />
    </div>
    <review-list />              <!-- list the reviews for the product-->
</div>
</template>

<script>
import AverageSummary from '@/components/AverageSummary.vue'
import StarSummary    from '@/components/StarSummary.vue'
import ReviewList     from '@/components/ReviewList.vue'
// We need to get the product id to be displayed in this page
// We need to get the product data from the Vuex data store for the id we are given in the path
// The product id is coming from the url path: product/:id
// Vue router creates the page when it gets a path it knows about
// Since we need the data before the page is created in order to place the data in page
//     a way to intercept the page create process and get the data is needed


export default {
    name:'product-detail',
    components: {
        AverageSummary,
        StarSummary,
        ReviewList
    },
    created() {  // Define code to be run for teh created hook in Vue processing
                 //        this code will run BEFORE Vue compiles the template which
                 //        generates the HTML for the page
    // we need to get the id from the URL and set the activeProductID in the data store to it
    const currentProductId = this.$route.params.id;  // Get the value of id from the URL
    this.$store.commit("SET_ACTIVE_PRODUCT", currentProductId);  // Tell data store to set the active project
    },
    // We need to get the product data from the Vuex data store for the id we are given in the path
    computed: {
        product() {  // this function will get the current product's data from the data store
            //              go to the data store products array and find the product with the id in the path
            //              we can use the array find() method to locate the element we want
            //              like most array function find() loops thorugh an array sending teh current element
            //                   to a function provided to it - the function is usually one statement and anonymous
            //                   .find((element-name) => {})
            //                   .find((element-name) => statement-that uses the element)
            //              $store.products give us access to the products in the data store 
            //              the product id of the product data we want we stored in $store.state.activeProduct
            
            // Loop through the array of products in the data store and find the one that matches the active product id
            return this.$store.state.products.find(
                (aProduct) => { return aProduct.id == this.$store.state.activeProduct;})
}
    }
}
</script>
<style scoped>
</style>
