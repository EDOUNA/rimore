<template>
  <div class="user">
    <h1>Create User</h1>

    <h3>Just some database interaction...</h3>

    <input type="text" v-model="user.firstName" placeholder="first name">
    <input type="text" v-model="user.lastName" placeholder="last name">

    <button @click="registerUser()">Create User</button>

    <div v-if="showResponse">
      <h6>User created with Id: {{ response }}</h6>
    </div>

    <button v-if="showResponse" @click="retrieveUser()">Retrieve user {{user.id}} data from database</button>

    <h4
      v-if="showRetrievedUser"
    >Retrieved User {{retrievedUser.firstName}} {{retrievedUser.lastName}}</h4>
  </div>
</template>

<script>
import { mapState, mapActions } from "vuex";
import axios from "axios";

export default {
  data() {
    return {
      response: [],
      errors: [],
      user: {
        firstName: "",
        lastName: "",
        emailAddress: ""
      },
      showResponse: false,
      retrievedUser: {},
      showRetrievedUser: false
    };
  },
  methods: {
    registerUser() {
      var parameters = new URLSearchParams();
      parameters.append("firstName", this.user.firstName);
      parameters.append("lastName", this.user.lastName);
      parameters.append("emailAddress", this.user.emailAddress);

      console.log(process.env.API_URL);

      axios
        .post(process.env.API_URL, parameters)
        .then(response => {
          this.response = response.data;
          this.showResponse = true;
        })
        .catch(e => {
          this.errors.push(e);
        });

        console.log(this.errors);
    },
    retrieveUser() {}
  }
};
</script>
