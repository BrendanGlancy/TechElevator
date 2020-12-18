import Vue from 'vue'        // Access to the Vue stuff
import App from './App.vue'  // Access the App.vue component

Vue.config.productionTip = false  // Disable hints about from Vue from the App - no longer needed - this is the default now

new Vue({                 // instantiate a Vue application
  render: h => h(App),    // render tells Vue what the main component is called - must match name of an import
}).$mount('#app')         // $mount - tells Vue where in in the index html the Vue components should be added
                          // #app - the element with id="app" will have all the Vue components added to to it
