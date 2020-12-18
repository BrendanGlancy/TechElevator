import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:3000"
});

export default {

  get(id) {
    return http.get(`/messages/${id}`);
  },

  add(message) {
    return http.post(`/messages/`, message);
  },

  update(message) {
    return http.put(`/messages/${ message.id }`, message)
  },

  delete(message) {
    return http.delete(`/messages/${ message }`)
  },
}
