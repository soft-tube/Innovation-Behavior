<template>
    <div style="display: flex;flex-direction: column;">
        <div>
            <el-input
                v-model="searchKey"
                style="width: 240px;margin-top: 5vh;"
                placeholder="请输入关键词"
                :suffix-icon="Search"
                @keyup.enter="getTransactions"
            />
        </div>
        <div class="card-container">
            <div v-for="card in cards" :key="card.title" class="card-item">
                <el-card class="hover-card">
                    <h3>{{ card.title }}</h3>
                    <p>{{ card.description }}</p>
                    <p>{{ card.pdf }}</p>
                    <p>{{ card.owner }}</p>
                    <p>{{ card.tel }}</p>
                    <p>{{ card.value }}</p>
                    <p>{{ card.time }}</p>
                </el-card>
            </div>
        </div>
    </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { Search } from '@element-plus/icons-vue'
import axios from 'axios';
const searchKey = ref('')
const cards = ref([
  { title: 'Card 1', description: 'Description 1', pdf:'1111111.pdf', owner:'XXZ',tel:"13333333333",value:'100w', time:'2222-22-22' },
  { title: 'Card 2', description: 'Description 2', pdf:'1111111.pdf', owner:'XXZ',tel:"13333333333",value:'100w', time:'2222-22-22' },
  { title: 'Card 3', description: 'Description 3', pdf:'1111111.pdf', owner:'XXZ',tel:"13333333333",value:'100w', time:'2222-22-22' },
  { title: 'Card 4', description: 'Description 4', pdf:'1111111.pdf', owner:'XXZ',tel:"13333333333",value:'100w', time:'2222-22-22' },
  { title: 'Card 5', description: 'Description 5', pdf:'1111111.pdf', owner:'XXZ',tel:"13333333333",value:'100w', time:'2222-22-22' },
  { title: 'Card 6', description: 'Description 6', pdf:'1111111.pdf', owner:'XXZ',tel:"13333333333",value:'100w', time:'2222-22-22' },
])
const formatDate = (dateString) => {
    const date = new Date(dateString);
    const year = date.getFullYear();
    const month = (date.getMonth() + 1).toString().padStart(2, '0');
    const day = date.getDate().toString().padStart(2, '0');
    const hours = date.getHours().toString().padStart(2, '0');
    const minutes = date.getMinutes().toString().padStart(2, '0');
    const seconds = date.getSeconds().toString().padStart(2, '0');

    return `${year}-${month}-${day} ${hours}:${minutes}:${seconds}`;
}
const getTransactions = async () => {
    try {
        response = await axios.get('api/' + searchKey.value);
        if (response.status === 200) {
            cards.value = response.data.data;
            cards.value.forEach(item => {
                item.time = formatDate(item.time);  // 格式化时间
            });
        }
    } catch (error) {
        console.error('Error fetching transactions details:', error);
    }
};

onMounted(() => {
    //getTransactions();
});
</script>

<style lang="scss" scoped>
.card-container {
  margin-top: 5vh;
  display: flex;
  flex-wrap: wrap; /* 允许子项换行 */
  gap: 20px; /* 控制卡片之间的间距 */
}

.card-item {
  flex: 1 1 calc(33.333% - 20px); /* 每个卡片占据三分之一宽度，并减去间距 */
  box-sizing: border-box;
}
.hover-card {
  transition: box-shadow 0.3s ease-in-out, transform 0.3s ease-in-out;
  cursor: pointer; /* 鼠标悬停时显示指针 */
}

.hover-card:hover {
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2), 0 6px 20px rgba(0, 0, 0, 0.19);
  transform: translateY(-5px); /* 提升效果 */
}
</style>