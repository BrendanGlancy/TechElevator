import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:3000"
});

export default {

  list() {
    return http.get('/topics');
  },

  get(id) {
    return http.get(`/topics/${id}`);
  },

  add(topic) {
    return http.post(`/topics`, topic);
  },

  update(topic) {
    return http.put(`/topics/${ topic.id }`, topic)
  },

 delete(topic) {
    return http.delete(`/topics/${ topic }`)
  }

  

}
