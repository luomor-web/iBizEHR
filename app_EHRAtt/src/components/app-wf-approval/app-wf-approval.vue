<template>
    <div class='app-wf-approval'>
        <div class="app-wf-approval-header">
            <span class="approval-header-left">{{data.startTime}}</span>
            <span>{{data.startUserName}}提交</span>
        </div>
        <div class="app-wf-approval-content" v-if="data.usertasks && data.usertasks.length >0">
            <div class="approval-content-item" v-for="(usertask,index) in data.usertasks" :key="index">
                <div class="approval-content-item-left">
                    {{usertask.userTaskName}}
                </div>
                <div class="approval-content-item-right">
                    <div class="approval-content-item-wait" v-if="usertask.identitylinks.length >0">
                        等待<span v-for="(identitylink,inx) in usertask.identitylinks" :key="inx">{{identitylink.displayname}}<span v-if="inx >0">、</span></span>处理
                    </div>
                    <div class="approval-content-item-info" v-if="usertask.comments.length >0">
                        <div v-for="(comment,commentInx) in usertask.comments" :key="commentInx">
                            <div class="approval-content-item-info-item approval-content-item-info-top">
                                {{`【${comment.type}】${comment.fullMessage}`}}
                            </div>
                             <div class="approval-content-item-info-item approval-content-item-info-bottom">
                                <span class="info-bottom-name">{{comment.authorName}}</span>
                                <span>{{comment.time}}</span>
                            </div>
                        </div>
                    </div>
                    <div class="approval-content-item-memo" v-if="usertask.userTaskId === viewparams.userTaskId">
                        <el-input type="textarea"  v-model="initmemo" :rows="2" @blur="handleBlur" placeholder="请输入内容"></el-input>
                    </div>
                </div>
            </div>
        </div>
         <div class="app-wf-approval-bottom">
            <span v-if="data.endTime">{{data.endTime}}结束</span>
        </div>
    </div>
</template>
<script lang = 'ts'>
import { Vue, Component,Prop,Model } from 'vue-property-decorator';

@Component({
})
export default class AppWFApproval extends Vue {

    /**
     * 双向绑定值
     * 
     *  @memberof AppWFApproval
     */
    @Model ('change')  value!: string;

    /**
     * 数据
     * 
     *  @memberof AppWFApproval
     */
    public data:any = {};

    /**
     *  初始化memo
     * 
     *  @memberof AppWFApproval
     */
    public initmemo:string = "";

    /**
     * 传入数据服务
     * 
     *  @memberof AppWFApproval
     */
    @Prop() public service:any;

    /**
     *  上下文
     * 
     *  @memberof AppWFApproval
     */
    @Prop() public context:any;

    /**
     *  视图参数
     * 
     *  @memberof AppWFApproval
     */
    @Prop() public viewparams:any;

    /**
     * 初始化数据
     * 
     *  @memberof AppWFApproval
     */
    public created(){
        if(this.service){
            this.service.GetWFHistory(this.context).then((res:any) =>{
                if(res && (res.status === 200)){
                    this.data = res.data;
                }
            })
        }
    }

    /**
     * 抛出wfprocmemo
     * 
     *  @memberof AppWFApproval
     */
    public handleBlur($event:any){
         this.$emit('change',$event.target.value);
    }
   
}
</script>

<style lang="less">
@import './app-wf-approval.less';
</style>