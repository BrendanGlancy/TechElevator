/* eslint-disable no-unused-vars, no-console */
import { shallowMount, Wrapper } from "@vue/test-utils";
import UserList from "@/components/UserList.vue";

import chai from "chai";
chai.should();

describe("UserList.vue", () => {
  /** @type Wrapper */
  let wrapper;

  // test user data
  const users = [
    {
      id: 1,
      firstName: "John",
      lastName: "Smith",
      username: "jsmith",
      emailAddress: "jsmith@gmail.com",
      status: "Active"
    },
    {
      id: 2,
      firstName: "Anna",
      lastName: "Bell",
      username: "abell",
      emailAddress: "abell@yahoo.com",
      status: "Active"
    },
    {
      id: 3,
      firstName: "George",
      lastName: "Best",
      username: "gbest",
      emailAddress: "gbest@gmail.com",
      status: "Disabled"
    },
    {
      id: 4,
      firstName: "Ben",
      lastName: "Carter",
      username: "bcarter",
      emailAddress: "bcarter@gmail.com",
      status: "Active"
    },
    {
      id: 5,
      firstName: "Katie",
      lastName: "Jackson",
      username: "kjackson",
      emailAddress: "kjackson@yahoo.com",
      status: "Active"
    },
    {
      id: 6,
      firstName: "Mark",
      lastName: "Smith",
      username: "msmith",
      emailAddress: "msmith@foo.com",
      status: "Disabled"
    }
  ];

  const filter = {
    firstName: "",
    lastName: "",
    username: "",
    emailAddress: "",
    status: ""
  };

  beforeEach(() => {
    wrapper = shallowMount(UserList);
    wrapper.setData({
      users: users.slice(),
      filter: filter
    });
  });

  describe("Display all users", () => {
    it("should display a list of users with correct data", () => {
      const rows = wrapper.findAll("#tblUsers tbody tr");
      rows.length.should.equal(7);
      let columns = rows.at(1).findAll("td");
      columns
        .at(1)
        .text()
        .should.equal(users[0].firstName);
      columns
        .at(2)
        .text()
        .should.equal(users[0].lastName);
      columns
        .at(3)
        .text()
        .should.equal(users[0].username);
      columns
        .at(4)
        .text()
        .should.equal(users[0].emailAddress);
      columns
        .at(5)
        .text()
        .should.equal(users[0].status);
    });

  });

  describe('Add new user form', () => {

    it('the add new user form should not be displayed by default', () => {
      wrapper.find('#frmAddNewUser').attributes().style.should.equal('display: none;')
    });

    it('should display the form when showForm is set to true', () => {
      wrapper.setData({
        showForm: true
      })
      wrapper.find('#frmAddNewUser').attributes().style.should.equal('')
    });

    it('save user should save a new user', () => {
      wrapper.setData({
        newUser: {
          id: 7,
          firstName: "TEST",
          lastName: "TEST",
          username: "test",
          emailAddress: "test@test.com",
          status: "Active"
        },
      });
      const currentCount = wrapper.vm.users.length;
      wrapper.vm.saveUser();
      wrapper.vm.users.length.should.equal(currentCount+1);
    });

  });

  describe('Single Row Enable / Disable Action ', () => {
    it('enable/disable button in row should display Disable if user status is Enable', () => {
      const buttons = wrapper.findAll('.btnEnableDisable');
      buttons.at(0).text().should.equal('Disable')
    })

    it('enable/disable button in row should display Enable if user status is Disabled', () => {
      const buttons = wrapper.findAll('.btnEnableDisable');
      buttons.at(2).text().should.equal('Enable')
    })

    it('should change the status when calling flip status', () => {
      const buttons = wrapper.findAll('.btnEnableDisable');
      buttons.at(0).text().should.equal('Disable')
      wrapper.vm.users[0].status.should.equal('Active')
      wrapper.vm.flipStatus(users[0].id)
      wrapper.vm.users[0].status.should.equal('Disabled')
    })

  });

  describe("Enable, Disable and Delete Actions", () => {

    it('computed property actionButtonDisabled should return true by default', () => {
      wrapper.vm.actionButtonDisabled.should.equal(true);
    })

    it('computed property actionButtonDisabled should return false if at least one user is selected', () => {
      wrapper.setData({
        selectedUserIDs: [1,2,3]
      })
      wrapper.vm.actionButtonDisabled.should.equal(false);
    })

    it('should select the third user and enable them', () => {
      wrapper.setData({
        selectedUserIDs: [3]
      })
      wrapper.vm.users[2].status.should.equal('Disabled');
      wrapper.vm.enableSelectedUsers();
      wrapper.vm.users[2].status.should.equal('Active');
    })

    it('should select multiple users and enable them', () => {
      wrapper.setData({
        selectedUserIDs: [1,2,3,4,5,6]
      })
      wrapper.vm.enableSelectedUsers();
      wrapper.vm.users[0].status.should.equal('Active');
      wrapper.vm.users[1].status.should.equal('Active');
      wrapper.vm.users[2].status.should.equal('Active');
      wrapper.vm.users[3].status.should.equal('Active');
      wrapper.vm.users[4].status.should.equal('Active');
      wrapper.vm.users[5].status.should.equal('Active');
    })

    it('should select the first user and disable them', () => {
      wrapper.setData({
        selectedUserIDs: [1] // holds id not index
      })
      wrapper.vm.users[0].status.should.equal('Active');
      wrapper.vm.disableSelectedUsers();
      wrapper.vm.users[0].status.should.equal('Disabled');
    })

    it('should select multiple users and disable them', () => {
      wrapper.setData({
        selectedUserIDs: [1,2,3,4,5,6]
      })
      wrapper.vm.disableSelectedUsers();
      wrapper.vm.users[0].status.should.equal('Disabled');
      wrapper.vm.users[1].status.should.equal('Disabled');
      wrapper.vm.users[2].status.should.equal('Disabled');
      wrapper.vm.users[3].status.should.equal('Disabled');
      wrapper.vm.users[4].status.should.equal('Disabled');
      wrapper.vm.users[5].status.should.equal('Disabled');
    })

    it('should delete a single user', () => {
      wrapper.setData({
        selectedUserIDs: [6]
      })
      const currentCount = wrapper.vm.users.length;
      wrapper.vm.deleteSelectedUsers();
      wrapper.vm.users.length.should.equal(currentCount - 1);
    })

    it('should delete multiple users', () => {
      wrapper.setData({
        selectedUserIDs: [1,2,3,4,5,6]
      })
      wrapper.vm.deleteSelectedUsers();
      wrapper.vm.users.length.should.equal(0);
    })

  });

  describe("Select All Actions", () => {

    it('select all should select all users', () => {
      const selAll = wrapper.findAll("#selectAll");
      selAll.at(0).setChecked();
      wrapper.vm.selectedUserIDs.length.should.equal(users.length);
    })

    it('select all should de-select all users if selected', () => {
      const selAll = wrapper.findAll("#selectAll");
      selAll.at(0).setChecked(true);
      wrapper.vm.selectedUserIDs.length.should.equal(users.length);
      selAll.at(0).setChecked(false); //click twice
      wrapper.vm.selectedUserIDs.length.should.equal(0);
    })

  });

});
