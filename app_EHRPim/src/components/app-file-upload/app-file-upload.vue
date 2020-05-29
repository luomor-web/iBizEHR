<template>
  <div class="app-file-upload">
    <el-row>
      <el-col v-if="rowPreview && files.length > 0" :span="12" class="upload-col">
          <el-button size='small' class="button-preview" icon='el-icon-view' :disabled="disabled" @click="()=>{this.dialogVisible = true;}">{{$t('components.appFileUpload.preview')}}<Badge :count="files.length" type="info"></Badge></el-button>
      </el-col>
      <el-col :span="(rowPreview && files.length > 0) ? 12 : 24" class="upload-col">
        <el-upload
          :disabled="disabled"
          :file-list="files"
          :action="uploadUrl"
          :headers="{}"
          :before-upload="beforeUpload"
          :before-remove="onRemove"
          :on-success="onSuccess"
          :on-error="onError"
          :on-preview="onDownload"
          :drag="isdrag"
          :show-file-list="!rowPreview"
          >
            <el-button v-if="!isdrag" size='small' icon='el-icon-upload' :disabled="disabled">{{this.$t('app.fileUpload.caption')}}</el-button>
          <i v-if="isdrag" class="el-icon-upload"></i>
          <div v-if="isdrag" class="el-upload__text" v-html="$t('components.appFileUpload.uploadText')"></div>
        </el-upload>
      </el-col>
    </el-row>
    <modal width="80%" v-model="dialogVisible" footer-hide class-name='upload-preview-modal'>
      <ul class="">
        <li v-for="(file,index) in files" :key="index" class="preview-file-list-item">
          <div class='preview-file-list-img'>
            <el-image :src="file.url" class='' style=''>
                <div slot='error' class='image-slot'>
                    <img src="/assets/img/picture.png" style='width:100%;height:100%;'>
                </div>
            </el-image>
            <div class='preview-file-list-actions' @mouseenter="()=>{showActions = true;}" @mouseleave="()=>{showActions = false;}">
                <span v-show="showActions" class='action-download'>
                    <i class='el-icon-download' @click="onDownload(file)"></i>
                </span>
                <span v-show="showActions" :style="{ 'display': disabled? 'none' : 'inline-block' }" class='action-delete'>
                    <i class='el-icon-delete' @click="onRemove(file, files)"></i>
                </span>
            </div>
          </div>
          <div class="file-name">{{file.name}}</div>
        </li>
      </ul>
    </modal>
  </div>
</template>

<script lang="ts">
import { Component, Vue, Prop, Watch } from 'vue-property-decorator';
import { Environment } from '@/environments/environment';
import { CreateElement } from 'vue';
import { Subject, Unsubscribable } from 'rxjs';

@Component({
})
export default class AppFileUpload extends Vue {

    /**
     * 表单状态
     *
     * @type {Subject<any>}
     * @memberof AppFileUpload
     */
    @Prop() public formState?: Subject<any>

    /**
     * 是否忽略表单项书香值变化
     *
     * @type {boolean}
     * @memberof AppFileUpload
     */
    @Prop() public ignorefieldvaluechange?: boolean;

    /**
     * 是否支持拖拽
     *
     * @type {boolean}
     * @memberof AppFileUpload
     */
    @Prop() public isdrag?: boolean;

    /**
     * 表单状态事件
     *
     * @private
     * @type {(Unsubscribable | undefined)}
     * @memberof AppFileUpload
     */
    private formStateEvent: Unsubscribable | undefined;

    /**
     * 表单数据
     *
     * @type {string}
     * @memberof AppFileUpload
     */
    @Prop() public data!: string;

    /**
     * 初始化值
     *
     * @type {*}
     * @memberof AppFileUpload
     */
    @Prop() public value?: any;

    /**
     * 数据值变化
     *
     * @param {*} newval
     * @param {*} val
     * @memberof AppFileUpload
     */
    @Watch('value')
    onValueChange(newval: any, val: any) {
        if (this.ignorefieldvaluechange) {
            return;
        }
        this.setFiles(newval)
        this.dataProcess();
    }

    /**
     * 所属表单项名称
     *
     * @type {string}
     * @memberof AppFileUpload
     */
    @Prop() public name!: string;

    /**
     * 是否禁用
     *
     * @type {boolean}
     * @memberof AppFileUpload
     */
    @Prop() public disabled?: boolean;

    /**
     * 上传参数
     *
     * @type {string}
     * @memberof AppFileUpload
     */
    @Prop() public uploadparams?: string;

    /**
     * 下载参数
     *
     * @type {string}
     * @memberof AppFileUpload
     */
    @Prop() public exportparams?: string;

    /**
     * 自定义参数
     *
     * @type {*}
     * @memberof AppFileUpload
     */
    @Prop() public customparams?: any;

    /**
     * 上传文件路径
     *
     * @memberof AppFileUpload
     */
    public uploadUrl = Environment.BaseUrl + Environment.UploadFile;

    /**
     * 下载文件路径
     *
     * @memberof AppFileUpload
     */
    public downloadUrl = Environment.BaseUrl + Environment.ExportFile;

    /**
     * 文件列表
     *
     * @memberof AppFileUpload
     */
    public files = [];

    /**
     * 上传keys
     *
     * @type {Array<any>}
     * @memberof AppFileUpload
     */
    public upload_keys: Array<any> = [];

    /**
     * 导出keys
     *
     * @type {Array<any>}
     * @memberof AppFileUpload
     */
    public export_keys: Array<any> = [];

    /**
     * 自定义数组
     *
     * @type {Array<any>}
     * @memberof AppFileUpload
     */
    public custom_arr: Array<any> = [];

    /**
     * 应用参数
     *
     * @type {*}
     * @memberof AppImageUpload
     */
    public appData: any;

    /**
     * 设置files
     *
     * @private
     * @memberof AppFileUpload
     */
    private setFiles(value:any): void {
        let _files = JSON.parse(value);
        if (value && Object.prototype.toString.call(_files)=='[object Array]') {
            this.files = _files;
        } else {
            this.files = [];
        }
    }

    /**
     * 数据处理
     *
     * @private
     * @memberof AppFileUpload
     */
    private dataProcess(): void {
        let upload_arr: Array<string> = [];
        let export_arr: Array<string> = [];
        const _data: any = JSON.parse(this.data);
        this.upload_keys.forEach((key: string) => {
            upload_arr.push(`${key}=${_data[key]}`);
        });
        this.export_keys.forEach((key: string) => {
            export_arr.push(`${key}=${_data[key]}`);
        });

        let _url = `${Environment.BaseUrl}${Environment.UploadFile}`;
        if (upload_arr.length > 0 || this.custom_arr.length > 0) {
            _url = `${_url}?${upload_arr.join('&')}${upload_arr.length > 0 ? '&' : ''}${this.custom_arr.join('&')}`;
        }
        this.uploadUrl = _url;

        this.files.forEach((file: any) => {
            let url = `${this.downloadUrl}/${file.id}`;
            if (upload_arr.length > 0 || this.custom_arr.length > 0) {
                url = `${url}?${upload_arr.join('&')}${upload_arr.length > 0 ? '&' : ''}${this.custom_arr.join('&')}`;
            }
            file.url = url;
        });
    }

    /**
     * vue 生命周期
     *
     * @memberof AppFileUpload
     */
    public created() {
        if (this.formState) {
            this.formStateEvent = this.formState.subscribe(($event: any) => {
                // 表单加载完成
                if (Object.is($event.type, 'load')) {
                    this.setFiles(this.value);
                    this.dataProcess();
                }
            });
        }
    }

    /**
     * vue 生命周期
     *
     * @returns
     * @memberof AppFileUpload
     */
    public mounted() {
        this.appData = this.$store.getters.getAppData();

        let uploadparams: string = '';
        let exportparams: string = '';

        let upload_keys: Array<string> = [];
        let export_keys: Array<string> = [];
        let custom_arr: Array<string> = [];
        if (this.uploadparams && !Object.is(this.uploadparams, '')) {
            uploadparams = this.uploadparams;
            upload_keys = uploadparams.split(';');
        }
        if (this.exportparams && !Object.is(this.exportparams, '')) {
            exportparams = this.exportparams;
            export_keys = exportparams.split(';');
        }
        if (this.customparams && !Object.is(this.customparams, '')) {
            Object.keys(this.customparams).forEach((name: string) => {
                custom_arr.push(`${name}=${this.customparams[name]}`);
            });
        }
        this.upload_keys = upload_keys;
        this.export_keys = export_keys;
        this.custom_arr = custom_arr;

        this.setFiles(this.value);
        this.dataProcess();
    }

    /**
     * 组件销毁
     *
     * @memberof AppFileUpload
     */
    public destroyed(): void {
        if (this.formStateEvent) {
            this.formStateEvent.unsubscribe();
        }
    }

    /**
     * 上传之前
     *
     * @param {*} file
     * @memberof AppFileUpload
     */
    public beforeUpload(file: any) {
        if(this.imageOnly){
            const imageTypes = ["image/jpeg" , "image/gif" , "image/png" , "image/bmp"];
            const isImage = imageTypes.some((type: any)=> Object.is(type, file.type));
            if (!isImage) {
              this.$Notice.error({ title: (this.$t('components.appFileUpload.fileTypeErrorTitle') as any) ,desc: (this.$t('components.appFileUpload.fileTypeErrorInfo') as any)});
            }
            return isImage;
        }
    }

    /**
     * 上传成功回调
     *
     * @param {*} response
     * @param {*} file
     * @param {*} fileList
     * @memberof AppFileUpload
     */
    public onSuccess(response: any, file: any, fileList: any) {
        if (!response) {
            return;
        }
        const data = { name: response.filename, id: response.fileid };
        let arr: Array<any> = [];
        this.files.forEach((_file:any) => {
            arr.push({name: _file.name, id: _file.id})
        });
        arr.push(data);

        let value: any = arr.length > 0 ? JSON.stringify(arr) : null;
        this.$emit('formitemvaluechange', { name: this.name, value: value });
    }

    /**
     * 上传失败回调
     *
     * @param {*} error
     * @param {*} file
     * @param {*} fileList
     * @memberof AppFileUpload
     */
    public onError(error: any, file: any, fileList: any) {
        this.$Notice.error({ title: (this.$t('components.appFileUpload.uploadError') as any) });
    }

    /**
     * 删除文件
     *
     * @param {*} file
     * @param {*} fileList
     * @memberof AppFileUpload
     */
    public onRemove(file: any, fileList: any) {
        let arr: Array<any> = [];
        fileList.forEach((f: any) => {
            if (f.id != file.id) {
                arr.push({ name: f.name, id: f.id });
            }
        });
        let value: any = arr.length > 0 ? JSON.stringify(arr) : null;
        if(arr.length == 0){
            this.dialogVisible = false;
        }
        this.$emit('formitemvaluechange', { name: this.name, value: value });
    }

    /**
     * 下载文件
     *
     * @param {*} file
     * @memberof AppFileUpload
     */
    public onDownload(file: any) {
        window.open(file.url);
    }

    /**
     * 是否只支持图片上传
     *
     * @type {boolean}
     * @memberof AppFileUpload
     */
    @Prop({default: false}) public imageOnly!: boolean;

    /**
     * 是否开启行内预览
     *
     * @type {boolean}
     * @memberof AppFileUpload
     */
    @Prop({default: false}) public rowPreview!: boolean;

    /**
     * 是否开启行内预览
     *
     * @type {boolean}
     * @memberof AppFileUpload
     */
    public dialogVisible: boolean = false;
    /**
     * 是否开启行内预览
     *
     * @type {boolean}
     * @memberof AppFileUpload
     */
    public showActions: boolean = false;


}
</script>

<style lang='less'>
@import './app-file-upload.less';
</style>