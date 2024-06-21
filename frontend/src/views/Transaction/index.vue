<template>

    <body>
        <div style="display: flex;flex-direction: column;">
            <!-- <div>
            <el-input
                v-model="searchKey"
                style="width: 240px;margin-top: 5vh;"
                placeholder="请输入关键词"
                :suffix-icon="Search"
                @keyup.enter="getTransactions"
            />
        </div> -->
            <div class="card-container">
                <div v-for="card in cards" :key="card.title" class="card-item">
                    <el-card class="hover-card">
                        <h3>{{ card.title }}</h3>
                        <h4>专利号：{{ card.appln_id }}</h4>
                        <p>专利概述：{{ card.description }}</p>
                        <p>专利拥有者：{{ card.owner }}</p>
                        <p>联系方式： {{ card.tel }}</p>
                        <p>意向转让价格： {{ card.value }}</p>
                        <p>发布时间： {{ card.time }}</p>
                    </el-card>
                </div>
            </div>
        </div>
    </body>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { Search } from '@element-plus/icons-vue'
import axios from 'axios';
const searchKey = ref('')
const cards = ref([])
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
        const response = await axios.get('/api/transactions');
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
    getTransactions();
});
</script>

<style lang="scss" scoped>
body {
    margin-top: 10px;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}
.card-container {
    margin-top: 5vh;
    display: flex;
    flex-wrap: wrap;
    /* 允许子项换行 */
    gap: 20px;
    /* 控制卡片之间的间距 */
}

.card-item {
    flex: 1 1 calc(33.333% - 20px);
    /* 每个卡片占据三分之一宽度，并减去间距 */
    box-sizing: border-box;
}

.hover-card {
    transition: box-shadow 0.3s ease-in-out, transform 0.3s ease-in-out;
    cursor: pointer;
    /* 鼠标悬停时显示指针 */
}

.hover-card:hover {
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2), 0 6px 20px rgba(0, 0, 0, 0.19);
    transform: translateY(-5px);
    /* 提升效果 */
}
</style>