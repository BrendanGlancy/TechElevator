<template>
  <div>
    <h1>Edit Card</h1>
    <card-form v-bind:cardID="parseInt($route.params.cardID)" />
  </div>
</template>

<script>
import CardForm from "@/components/CardForm";

export default {
  components: {
    CardForm
  }
};
</script>
