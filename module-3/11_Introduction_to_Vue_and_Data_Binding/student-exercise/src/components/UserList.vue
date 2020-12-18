<template>
  <table id="tblUsers">
    <thead>
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Username</th>
        <th>Email Address</th>
        <th>Status</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
      <tr>
        <td>
          <input type="text" id="firstNameFilter" v-model="filter.firstName"/>
        </td>
        <td>
          <input type="text" id="lastNameFilter"  v-model="filter.lastName"/>
        </td>
        <td>
          <input type="text" id="usernameFilter"  v-model="filter.username"/>
        </td>
        <td>
          <input type="text" id="emailFilter"  v-model="filter.emailAddress"/>
        </td>
        <td>
          <select id="statusFilter" v-model="filter.status">
            <option value>Show All</option>
            <option value="Active">Active</option>
            <option value="Disabled">Disabled</option>
          </select>
        </td>
      </tr>
      <tr v-for="user in filteredList" v-bind:key="user.id" :class="{disabled: user.status === 'Disabled'}">
      <!-- user listing goes here -->
        <td>{{ user.firstName }}</td>
        <td>{{ user.lastName }}</td>
        <td>{{ user.username }}</td>
        <td>{{ user.emailAddress }}</td>
        <td>{{ user.status }}</td>
      </tr>
    </tbody>
  </table> 

</template>



<script>
export default {
  name: 'user-list',
  data() {
    return {
      filter: {
        firstName: "",
        lastName: "",
        username: "",
        emailAddress: "",
        status: ""
      },
      users: [
        {
          //id: 1,
          firstName: "John",
          lastName: "Smith",
          username: "jsmith",
          emailAddress: "jsmith@gmail.com",
          status: "Active"
        },
        {
          //id: 2,
          firstName: "Anna",
          lastName: "Bell",
          username: "abell",
          emailAddress: "abell@yahoo.com",
          status: "Active"
        },
        {
          //id: 3,
          firstName: "George",
          lastName: "Best",
          username: "gbest",
          emailAddress: "gbest@gmail.com",
          status: "Disabled"
        },
        {
          //id: 4,
          firstName: "Ben",
          lastName: "Carter",
          username: "bcarter",
          emailAddress: "bcarter@gmail.com",
          status: "Active"
        },
        {
          //id: 5,
          firstName: "Katie",
          lastName: "Jackson",
          username: "kjackson",
          emailAddress: "kjackson@yahoo.com",
          status: "Active"
        },
        {
          //id: 6,
          firstName: "Mark",
          lastName: "Smith",
          username: "msmith",
          emailAddress: "msmith@foo.com",
          status: "Disabled"
        }
      ]

    }
  },

  computed: {
  filteredList() {
    let filteredUsers = this.users;
    if (this.filter.firstName != "") {
      filteredUsers = filteredUsers.filter((user) =>
        user.firstName
          .toLowerCase()
          .includes(this.filter.firstName.toLowerCase())
      );
    }
    if (this.filter.lastName != "") {
      filteredUsers = filteredUsers.filter((user) =>
        user.lastName
          .toLowerCase()
          .includes(this.filter.lastName.toLowerCase())
      );
    }
    if (this.filter.username != "") {
      filteredUsers = filteredUsers.filter((user) =>
        user.username
          .toLowerCase()
          .includes(this.filter.username.toLowerCase())
      );
    }
    if (this.filter.emailAddress != "") {
      filteredUsers = filteredUsers.filter((user) =>
        user.emailAddress
          .toLowerCase()
          .includes(this.filter.emailAddress.toLowerCase())
      );
    }
    if (this.filter.status != "") {
      filteredUsers = filteredUsers.filter((user) =>
        user.status === this.filter.status
      );
    }
    return filteredUsers;
  }
}

}

</script>

<style scoped>
table {
  margin-top: 20px;
  font-family:-apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif
}
th {
  text-transform: uppercase
}
td {
  padding: 10px;
}
tr.disabled {
  color: red;
}
input, select {
  font-size: 16px;
}
</style> 
