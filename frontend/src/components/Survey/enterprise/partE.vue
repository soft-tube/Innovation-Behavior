<template>
    <el-card style="border-radius: 15px;width: 100%;">
        <el-form :model="form" size="large" label-position="top">
            <el-form-item class="question" style="font-weight: bolder;" label="E01.您如何评价过去五年的知识产权营商环境？">
                <el-form-item class="question blue-label" style="font-weight: bolder;" label="（请打分，1🌟为非常差，5🌟为非常好）" />
                <el-table :data="tablePEQ01" style="width: 100%" :row-style="{ height: '10px' }"
                    :cell-style="{ padding: '0px' }">
                    <el-table-column class="answer" width="300%">
                        <template #default="{ row }">
                            {{ row.name }}
                        </template>
                    </el-table-column>
                    <el-table-column width="200%" class="answer" header-align="center"
                        v-for="(column, colIndex) in colPEQ01" :key="colIndex" :label="column.label">
                        <template #default="{ row }">
                            <el-rate text-color="#ff9900" size="large" v-model="row.rate[colIndex]"
                                :texts="['not', 'so-so', 'relative', 'very', 'super']" show-text class="table-container"
                                @change="handlePEQ01(row, colIndex)" />
                        </template>
                    </el-table-column>
                </el-table>
            </el-form-item>

            <el-form-item class="question" style="font-weight: bolder;" label="E02.您是否了解以下专利许可机制？">
                <el-table :data="tablePEQ2" style="width: 100%" :row-style="{ height: '10px' }"
                    :cell-style="{ padding: '0px' }">
                    <el-table-column class="answer" width="200%">
                        <template #default="{ row }">
                            {{ row.name }}
                        </template>
                    </el-table-column>
                    <el-table-column width="150%" class="answer" header-align="center"
                        v-for="(column, colIndex) in colPEQ2" :key="colIndex" :label="column.label">
                        <template #default="{ row }">
                            <!-- 在每个单元格内放置一个可选中的组件 -->
                            <el-checkbox class="table-container1" v-model="row.selection[colIndex]"
                                @change="handlePEQ2(row, colIndex)"></el-checkbox>
                        </template>
                    </el-table-column>
                </el-table>
            </el-form-item>
            <el-form-item class="question" style="font-weight: bolder;" label="E03.贵司是否参加过以下专利运营相关服务？">
                <el-form-item class="question blue-label" style="font-weight: bolder;" label="（请打分，1🌟为没有，5🌟为许多次）" />
                <el-table :data="tablePEQ3" style="width: 100%" :row-style="{ height: '10px' }"
                    :cell-style="{ padding: '0px' }">
                    <el-table-column class="answer" width="350%">
                        <template #default="{ row }">
                            {{ row.name }}
                        </template>
                    </el-table-column>
                    <el-table-column width="250%" class="answer" header-align="center"
                        v-for="(column, colIndex) in colPEQ3" :key="colIndex" :label="column.label">
                        <template #default="{ row }">
                            <el-rate text-color="#ff9900" size="large" v-model="row.rate"
                                :texts="['not', 'so-so', 'relative', 'very', 'super']" show-text class="table-container"
                                @change="handlePEQ03(row, colIndex)" />
                        </template>
                    </el-table-column>
                </el-table>
            </el-form-item>
            <el-form-item class="question" style="font-weight: bolder;" label="E04.贵司是否获得过以下专利运营相关的政策资助？">
                <el-form-item class="question blue-label" style="font-weight: bolder;" label="（请打分，1🌟为没有，5🌟为许多次）" />
                <el-table :data="tablePEQ4" style="width: 100%" :row-style="{ height: '10px' }"
                    :cell-style="{ padding: '0px' }">
                    <el-table-column class="answer" width="250%">
                        <template #default="{ row }">
                            {{ row.name }}
                        </template>
                    </el-table-column>
                    <el-table-column width="250%" class="answer" header-align="center"
                        v-for="(column, colIndex) in colPEQ4" :key="colIndex" :label="column.label">
                        <template #default="{ row }">
                            <el-rate text-color="#ff9900" size="large" v-model="row.rate"
                                :texts="['not', 'so-so', 'relative', 'very', 'super']" show-text class="table-container"
                                @change="handlePEQ04(row, colIndex)" />
                        </template>
                    </el-table-column>
                </el-table>
            </el-form-item>

            <el-form-item class="question" style="font-weight: bolder;" label="E05.您认为政府应当提升以下哪几类公共服务的投入？">
                <el-form-item class="question blue-label" style="font-weight: bolder;"
                    label="（请打分，1🌟为不用提高，5🌟为大幅提高）" />
                <el-table :data="tablePEQ5" style="width: 100%" :row-style="{ height: '10px' }"
                    :cell-style="{ padding: '0px' }">
                    <el-table-column class="answer" width="400%">
                        <template #default="{ row }">
                            {{ row.name }}
                        </template>
                    </el-table-column>
                    <el-table-column width="250%" class="answer" header-align="center"
                        v-for="(column, colIndex) in colPEQ5" :key="colIndex" :label="column.label">
                        <template #default="{ row }">
                            <el-rate text-color="#ff9900" size="large" v-model="row.rate"
                                :texts="['not', 'so-so', 'relative', 'very', 'super']" show-text class="table-container"
                                @change="handlePEQ05(row, colIndex)" />
                        </template>
                    </el-table-column>
                </el-table>
            </el-form-item>

        </el-form>
        <el-button type="primary" @click="submit()" style="margin-top: 1vh;margin-left: 2vw;">提交问卷（E部分）</el-button>

        <el-dialog style="font-family: SimSun;width: 40vw;align-items: center;justify-content: center;" title="纪念品领取"
            v-model="dialogVisible" :before-close="handleClose">
            <el-card style="gap: 6px;border: none;align-items: center;justify-content: center;display: flex;"
                shadow="never">
                <el-container style="margin-bottom: 2vh;">为感谢您的参与，我们为您准备了一份纪念品。</el-container>
                <el-container>
                    <el-image :src="award"></el-image>
                </el-container>
                <el-container style="margin-top: 2vh">
                    您可以选择:
                </el-container>
                <el-radio-group v-model="awardForm.award">
                    <el-radio class="answer" label="直接获得一份纪念品" />
                    <el-radio class="answer" label="选择抛硬币游戏：如果抛出正面，获得两份纪念品。" />
                </el-radio-group>
            </el-card>
            <template #footer>
                <div class="dialog-footer">
                    <el-button @click="dialogVisible = false">取消</el-button>
                    <el-button type="primary" @click="submitAward">
                        确认
                    </el-button>
                </div>
            </template>
        </el-dialog>
    </el-card>
</template>

<script setup>
import { ref, reactive } from 'vue';
import { surveyStore,tableColChange } from '../../../stores/survey';
import axios from 'axios';
import { ElMessage } from 'element-plus';
import award from '../../../public/img/award.png'
const surveyInfo = surveyStore().surveyInfo
const form = reactive({
    pEq01: [],
    pEq02: [],
    pEq03: [],
    pEq04: [],
    pEq05: [],
});

const awardForm = reactive({
    patentNo: "",
    award:"",
    address:""
})

const dialogVisible = ref(false)

//以下实现所有表格
const tablePEQ01 = ref([
    { name: "专利的审查效率", rate: [0,0] },
    { name: "专利申请注册过程中的信息系统便利程度", rate: [0, 0] },
    { name: "专利申请的成本（包含申请费、代理费）", rate: [0, 0] },
    { name: "专利诉讼成本（包含律师费等）", rate: [0, 0] },
    { name: "专利保护的力度（如惩罚性赔偿额度等）", rate: [0, 0] },
    { name: "对待不同创新主体，专利审查决定的公平性", rate: [0, 0] },
    { name: "对待不同创新主体，专利侵权裁决、行政执法的公平性", rate: [0, 0] },
]);

const colPEQ01 = [
    { label: "2018" },
    { label: "2023" }
];

// 处理单元格选中状态变化
const handlePEQ01 = (row, colIndex) => {
    // 取消当前行其他单元格的选中状态
    form.pEq01 = tablePEQ01
};

const tablePEQ2 = ref([
    { name: "特斯拉的专利开放",selection: [false, false, false] },
    { name: "专利许可备案制度",selection: [false, false, false] },
    { name: "专利豁免",selection: [false, false, false] },
    { name: "专利强制许可制度",selection: [false, false, false] },
    { name: "专利开放许可制度",selection: [false, false, false] },
    { name: "药品专利池 MPP", selection: [false, false, false] },
    { name: "医药专利链接制度", selection: [false, false, false] },
    { name: "标准必要专利", selection: [false, false, false] },
]);

const colPEQ2 = [
    { label: "参与过" },
    { label: "了解，没参与过" },
    { label: "不太了解" },
];

// 处理单元格选中状态变化
const handlePEQ2 = (row, colIndex) => {
    const rowIndex = tablePEQ2.value.indexOf(row);
    tableColChange(tablePEQ2.value,rowIndex,colIndex)    
    form.pEq02 = tablePEQ2
};

const tablePEQ3 = ref([
    { name: "参加提升知识产权运营能力的培训/公益讲座",rate: 0 },
    { name: "参加知识产权运营政策的政策咨询讲座", rate: 0 },
    { name: "参加专利技术的路演推介活动", rate: 0 },
    { name: "使用公共部门搭建的专利在线交易平台", rate: 0 },
    { name: "获得专利许可交易的定价指导", rate: 0 },
]);

const colPEQ3 = [
    { label: "没有-->许多次" },
];

// 处理单元格选中状态变化
const handlePEQ03 = (row, colIndex) => {
    // 取消当前行其他单元格的选中状态
    form.pEq03 = tablePEQ3
};

const tablePEQ4 = ref([
    { name: "获得高价值专利的奖励", rate: 0 },
    { name: "获得知识产权试点示范项目奖励", rate: 0 },
    { name: "获得专利转化成果奖励", rate: 0 },
    { name: "获得专利续费的减免或补贴", rate: 0 },
    { name: "享受研发费用的加计扣除", rate: 0 },
    { name: "获得专利许可收益相关的税收减免", rate: 0 },
]);

const colPEQ4 = [
    { label: "没有-->许多次" },
];

// 处理单元格选中状态变化
const handlePEQ04 = (row, colIndex) => {
    // 取消当前行其他单元格的选中状态
    form.pEq04 = tablePEQ4
};

const tablePEQ5 = ref([
    { name: "举办知识产权运营能力的培训/公益讲座", rate: 0 },
    { name: "举办知识产权运营政策的政策咨询讲座", rate: 0 },
    { name: "发布诸如《专利开放许可使用费估算指引》等指导手册", rate: 0 },
    { name: "举办专利技术的路演推介活动", rate: 0 },
    { name: "提供、搭建专利在线交易平台", rate: 0 },
    { name: "提供专利许可交易的公益性定价指导", rate: 0 },
    { name: "提供给高价值专利的奖励", rate: 0 },
    { name: "提供专利转移转化成果奖励", rate: 0 },
    { name: "获得专利续费的减免或补贴", rate: 0 },
    { name: "享受研发费用的加计扣除", rate: 0 },
    { name: "获得专利许可收益相关的税收减免", rate: 0 },
]);

const colPEQ5 = [
    { label: "不用提高-->大幅提高" },
];

// 处理单元格选中状态变化
const handlePEQ05 = (row, colIndex) => {
    // 取消当前行其他单元格的选中状态
    form.pEq05 = tablePEQ5
};
const changeTable = (table, col) => {
    let results = [];
    for (let i = 0; i < table.length; i++) {
        for (let j = 0; j < table[i].selection.length; j++) {
            if (table[i].selection[j]) {
                results.push({ row: table[i].name, col: col[j].label });
            }
        }
    }
    return results
}
const submit = async () => {
    // 深拷贝
    let formData = JSON.parse(JSON.stringify(form));
    formData.pEq02=changeTable(formData.pEq02,colPEQ2)
    // 将表单数据转换为对象数组
    const formDataArray = Object.entries(formData).map(([key, value]) => ({ [key]: value }));

    // 将对象数组字符串化
    const formDataString = JSON.stringify(formDataArray);

    const patentNo = surveyInfo.patentNo

    console.log(patentNo)
    console.log(formDataString);


    const invitationCode = surveyInfo.curInvitationCode

    const data = {
        invitationCode: invitationCode,
        patentNo: patentNo,
        policy: formDataString
    };
    let response = await axios.post('/api/survey/policy', data);
    if (response.status == 200) {
        if (response.data.code == 1) {
            ElMessage.success("submit successfully")
            dialogVisible.value = true
        }
    }
}
const submitAward = async () => {
    awardForm.patentNo = surveyInfo.patentNo
    dialogVisible.value = false
    console.log(awardForm)
    let response = await axios.post('/api/survey/award', awardForm);
    if (response.status == 200) {
        if (response.data.code == 1) {
            ElMessage.success("成功提交奖励")
        } else{
            ElMessage.error("您已选择奖励")
        }
    }
}
</script>

<style scoped>
:deep(.el-radio__label) {
    white-space: normal;
    /* 换行 */
}

:deep(.el-checkbox__label) {
    white-space: normal;
    /* 换行 */
}
.question {
    font-weight: bolder;
    font-family: SimSun;
}

.answer {
    font-family: KaiTi;
    margin-left: 2em;
}

.table-container {
    display: flex;
    margin-left: 2vw;
}
.table-container1 {
    display: flex;
    justify-content: center;

    align-items: center;

}
.el-table {
    margin-left: 2.5em;
    margin-top: 1vh;
}

::v-deep.el-table th {
    border: 1px solid rgb(105, 102, 102) !important;
    border-right: none !important;
    border-bottom: none !important;
    border-top: none !important;
    /* border-left: none !important; */
}

::v-deep.el-table td {
    border: 1px solid rgb(105, 102, 102);
    border-right: none !important;
    border-bottom: none !important;
    /* border-left: none !important; */
}

::v-deep .el-table {
    border-collapse: separate;
    border: none !important;
}

.ps{
    color: rgb(0,112,192);
}
::v-deep .el-form-item__label {
    font-size: 17px;

}
</style>
