<template>
    <div class="lectures-container">
      <router-link
        v-for="lecture in lectures"
        :key="lecture.id"
        class="lecture-card"
        :to="`/lecture/${lecture.id}`"
      >
        <h2>{{ lecture.title }}</h2>
      </router-link>
    </div>
  </template>
  
  <script>
  export default {
    name: "LecturesList",
    data() {
      return {
        lectures: [
          { id: 1, title: "Addition" },
          { id: 2, title: "Subtraction" },
          { id: 3, title: "Multiplication" },
          { id: 4, title: "Division" },
          { id: 5, title: "Fractions" },
          { id: 6, title: "Decimals" },
          { id: 7, title: "Percents" },
          { id: 8, title: "Geometry" },
          { id: 9, title: "Algebre" },
          { id: 10, title: "Probability" },
        ],
      };
    },
  };
  </script>
  <style scoped>
  * {
    box-sizing: border-box;
    margin: 0;
    padding: 0;
  }
  
  html,
  body {
    height: 100%;
    font-family: "Arial", sans-serif;
    background-color: #f0f4f8;
  }
  
  body {
    display: flex;
    flex-direction: column;
  }
  
  #app {
    flex: 1 0 auto;
    display: flex;
    flex-direction: column;
  }
  
  header {
    background-color: #5c9ee7;
    padding: 20px 0;
    text-align: center;
  }
  
  .logo {
    max-height: 80px;
    margin-right: 10px;
    vertical-align: middle;
  }
  
  h1 {
    font-size: 2.5rem;
    color: #ffffff;
    display: inline;
  }
  
  main {
    padding: 20px;
    flex: 1 0 auto;
  }
  
  .lectures-container {
    display: grid;
    grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
    grid-row-gap: 5px;
    grid-column-gap: 10px;
    justify-items: center;
    min-height: calc(100vh - 180px);
    grid-auto-rows: minmax(0, max-content); /* Add this line to dynamically adjust row height */
  }
  
  .lecture-card {
    text-decoration: none;
    color: inherit;
    background-color: #ffffff;
    border-radius: 15px;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    margin: 10px;
    padding: 20px;
    width: 180px;
    height: 120px;
    display: flex; /* Add this line to use flexbox */
    justify-content: center; /* Add this line to center the content horizontally */
    align-items: center; /* Add this line to center the content vertically */
    text-align: center;
    cursor: pointer;
    transition: transform 0.3s, box-shadow 0.3s;
  }
  
  .lecture-card:hover {
    transform: scale(1.05);
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
  }
  
  footer {
    background-color: #5c9ee7;
    padding: 10px 0;
    text-align: center;
    color: #ffffff;
    flex-shrink: 0;
  }
  
  </style>