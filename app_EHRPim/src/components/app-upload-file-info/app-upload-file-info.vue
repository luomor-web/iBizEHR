<template>
  <div class="app-upload-file-info">
      <a class="file-item" v-for="file in files" @click="() => onDownload(file)"><i class="el-icon-document"></i>{{file.name}}</a>
  </div>
</template>

<script lang="ts">
import { Component, Vue, Prop, Watch } from 'vue-property-decorator';
import { Environment } from '@/environments/environment';
import { CreateElement } from 'vue';
import { Subject, Unsubscribable } from 'rxjs';

@Component({
})
export default class AppUploadFileInfo extends Vue {

    /**
     * 初始化值
     *
     * @type {*}
     * @memberof AppUploadFileInfo
     */
    @Prop() public value?: any;

    /**
     * 数据值变化
     *
     * @param {*} newval
     * @param {*} val
     * @memberof AppUploadFileInfo
     */
    @Watch('value')
    onValueChange(newval: any, val: any) {
        this.dataProcess();
    }

    /**
     * 所属表单项名称
     *
     * @type {string}
     * @memberof AppUploadFileInfo
     */
    @Prop() public name!: string;

    /**
     * 上传文件路径
     *
     * @memberof AppUploadFileInfo
     */
    public uploadUrl = Environment.BaseUrl + Environment.UploadFile;

    /**
     * 下载文件路径
     *
     * @memberof AppUploadFileInfo
     */
    public downloadUrl = Environment.BaseUrl + Environment.ExportFile;

    /**
     * 文件列表
     *
     * @memberof AppUploadFileInfo
     */
    public files = [];

    /**
     * 数据处理
     *
     * @private
     * @memberof AppUploadFileInfo
     */
    private dataProcess(): void {
        if(this.value){
            let files = JSON.parse(this.value);
            if(files.length){
                files.forEach((file: any) => {
                    let url = `${this.downloadUrl}/${file.id}`;
                    file.url = url;
                });
            }else{
              files = []
            }
            this.files =files;
        }
    }

    /**
     * vue 生命周期
     *
     * @memberof AppUploadFileInfo
     */
    public created() {
        this.dataProcess();
    }


    /**
     * 下载文件
     *
     * @param {*} file
     * @memberof AppUploadFileInfo
     */
    public onDownload(file: any) {
        window.open(file.url);
    }

}
</script>

<style lang='less'>
@import './app-upload-file-info.less';
</style>