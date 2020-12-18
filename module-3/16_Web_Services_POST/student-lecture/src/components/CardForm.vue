<template>
  <form v-on:submit.prevent="submitForm" class="cardForm">
    <div class="status-message error" v-show="errorMsg !== ''">{{errorMsg}}</div>
    <div class="form-group">
      <label for="title">Title:</label>
      <input id="title" type="text" class="form-control" v-model="card.title" autocomplete="off" />
    </div>
    <div class="form-group">
      <label for="tag">Tag:</label>
      <select id="tag" class="form-control" v-model="card.tag">
        <option value="Feature Request">Feature Request</option>
        <option value="Design">Design</option>
        <option value="Q&A">Q&A</option>
      </select>
      <label for="status">Status:</label>
      <select id="tag" class="form-control" v-model="card.status">
        <option value="Planned">Planned</option>
        <option value="In Progress">In Progress</option>
        <option value="Completed">Completed</option>
      </select>
    </div>
    <div class="form-group">
      <label for="description">Description:</label>
      <textarea id="description" class="form-control" v-model="card.description"></textarea>
    </div>
    <button class="btn btn-submit">Submit</button>
    <button class="btn btn-cancel" v-on:click.prevent="cancelForm" type="cancel">Cancel</button>
  </form>
</template>

<script>
import boardsService from "../services/BoardService";
import moment from "moment";

export default {
  name: "card-form",
  props: {
    cardID: {
      type: Number,
      default: 0
    }
  },
  data() {
    return {
      card: {
        title: "",
        description: "",
        status: "Planned",
        tag: "",
        avatar: "",
        date: null
      },
      errorMsg: ""
    };
  },
  methods: {
    submitForm() {
      const newCard = {
        boardId: Number(this.$route.params.boardID),
        title: this.card.title,
        description: this.card.description,
        status: this.card.status,
        tag: this.card.tag,
        avatar: "https://randomuser.me/api/portraits/lego/1.jpg",
        date: moment().format("MMM Do YYYY")
      };

      if (this.cardID === 0) {
        // add
        boardsService
          .addCard(newCard)
          .then(response => {
            if (response.status === 201) {
              this.$router.push(`/board/${newCard.boardId}`);
            }
          })
          .catch(error => { 
            this.handleErrorResponse(error, "adding");
          });
      } else {
        // update
        newCard.id = this.cardID;
        newCard.avatar = this.card.avatar;
        newCard.date = this.card.date;
        boardsService
          .updateCard(newCard)
          .then(response => {
            if (response.status === 200) {
              this.$router.push(`/board/${newCard.boardId}`);
            }
          })
          .catch(error => {
            this.handleErrorResponse(error, "updating");
          });
      }
    },
    cancelForm() {
      this.$router.push(`/board/${this.$route.params.boardID}`);
    },

    /**************************************************************
    *
    * Common API error handling routine
    * Two types of API errors that might occur:
    *   request error - something was wrong in trying to get to the server
    *   response error - you go to the server, something wrong with your request
    *
    ***************************************************************/

    handleErrorResponse(error, verb) {
      if (error.response) { // if it was a response error..
        this.errorMsg = // set our error message attribute to some verbage 
          "Error " + verb + " card. Response received was '" +
          error.response.statusText +
          "'.";
      } else if (error.request) { // if it was a request error..
        this.errorMsg = // set errorMsg to say can't reach server
          "Error " + verb + " card. Server could not be reached.";
      } else {
        this.errorMsg =
          "Error " + verb + " card. Request could not be created.";
      }
    }
  },
  created() {
    if (this.cardID != 0) {
      boardsService
        .getCard(this.cardID)
        .then(response => {
          this.card = response.data;
        })
        .catch(error => {
          if (error.response && error.response.status === 404) {
            alert(
              "Card not available. This card may have been deleted or you have entered an invalid card ID."
            );
            this.$router.push("/");
          }
        });
    }
  }
};
</script>


<style>
.cardForm {
  padding: 10px;
  margin-bottom: 10px;
}
.form-group {
  margin-bottom: 10px;
  margin-top: 10px;
}
label {
  display: inline-block;
  margin-bottom: 0.5rem;
}
.form-control {
  display: block;
  width: 80%;
  height: 30px;
  padding: 0.375rem 0.75rem;
  font-size: 1rem;
  font-weight: 400;
  line-height: 1.5;
  color: #495057;
  border: 1px solid #ced4da;
  border-radius: 0.25rem;
}
textarea.form-control {
  height: 75px;
  font-family: Arial, Helvetica, sans-serif;
}
select.form-control {
  width: 20%;
  display: inline-block;
  margin: 10px 20px 10px 10px;
}
.btn-submit {
  color: #fff;
  background-color: #0062cc;
  border-color: #005cbf;
}
.btn-cancel {
  color: #fff;
  background-color: #dc3545;
  border-color: #dc3545;
}
.status-message {
  display: block;
  border-radius: 5px;
  font-weight: bold;
  font-size: 1rem;
  text-align: center;
  padding: 10px;
  margin-bottom: 10px;
}
.status-message.success {
  background-color: #90ee90;
}
.status-message.error {
  background-color: #f08080;
}
</style>
