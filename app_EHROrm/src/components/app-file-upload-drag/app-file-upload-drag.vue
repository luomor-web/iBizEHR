<template>
    <el-upload
     class="upload-demo"
      :disabled="disabled"
      :file-list="files"
      :action="uploadUrl"
      :headers="{}"
      :before-upload="beforeUpload"
      :before-remove="onRemove"
      :on-success="onSuccess"
      :on-error="onError"
      :on-preview="onDownload"
      drag
      >
      <i class="el-icon-upload"></i>
      <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
    </el-upload>
    
</template>

<script lang="ts">
import { Component, Vue, Prop, Watch } from 'vue-property-decorator';
import { Environment } from '@/environments/environment';
import { CreateElement } from 'vue';
import { Subject, Unsubscribable } from 'rxjs';

@Component({})
export default class AppFileUploadDrag extends Vue {

    /**
     * 表单状态
     *
     * @type {Subject<any>}
     * @memberof AppFileUploadDrag
     */
    @Prop() public formState?: Subject<any>

    /**
     * 是否忽略表单项书香值变化
     *
     * @type {boolean}
     * @memberof AppFileUploadDrag
     */
    @Prop() public ignorefieldvaluechange?: boolean;

    /**
     * 表单状态事件
     *
     * @private
     * @type {(Unsubscribable | undefined)}
     * @memberof AppFileUploadDrag
     */
    private formStateEvent: Unsubscribable | undefined;

    /**
     * 表单数据
     *
     * @type {string}
     * @memberof AppFileUploadDrag
     */
    @Prop() public data!: string;

    /**
     * 初始化值
     *
     * @type {*}
     * @memberof AppFileUploadDrag
     */
    @Prop() public value?: any;

    /**
     * 数据值变化
     *
     * @param {*} newval
     * @param {*} val
     * @memberof AppFileUploadDrag
     */
    @Watch('value')
    onValueChange(newval: any, val: any) {
        if (this.ignorefieldvaluechange) {
            return;
        }
        if (newval) {
            this.files = JSON.parse(newval);
            this.dataProcess();
        } else {
            this.files = [];
        }
    }

    /**
     * 所属表单项名称
     *
     * @type {string}
     * @memberof AppFileUploadDrag
     */
    @Prop() public name!: string;

    /**
     * 是否禁用
     *
     * @type {boolean}
     * @memberof AppFileUploadDrag
     */
    @Prop() public disabled?: boolean;

    /**
     * 上传参数
     *
     * @type {string}
     * @memberof AppFileUploadDrag
     */
    @Prop() public uploadparams?: string;

    /**
     * 下载参数
     *
     * @type {string}
     * @memberof AppFileUploadDrag
     */
    @Prop() public exportparams?: string;

    /**
     * 自定义参数
     *
     * @type {*}
     * @memberof AppFileUploadDrag
     */
    @Prop() public customparams?: any;

    /**
     * 上传文件路径
     *
     * @memberof AppFileUploadDrag
     */
    public uploadUrl = Environment.BaseUrl + Environment.UploadFile;

    /**
     * 下载文件路径
     *
     * @memberof AppFileUploadDrag
     */
    public downloadUrl = Environment.BaseUrl + Environment.ExportFile;

    /**
     * 文件列表
     *
     * @memberof AppFileUploadDrag
     */
    public files = [];

    /**
     * 上传keys
     *
     * @type {Array<any>}
     * @memberof AppFileUploadDrag
     */
    public upload_keys: Array<any> = [];

    /**
     * 导出keys
     *
     * @type {Array<any>}
     * @memberof AppFileUploadDrag
     */
    public export_keys: Array<any> = [];

    /**
     * 自定义数组
     *
     * @type {Array<any>}
     * @memberof AppFileUploadDrag
     */
    public custom_arr: Array<any> = [];

    /**
     * 应用参数
     *
     * @type {*}
     * @memberof AppFileUploadDrag
     */
    public appData: any;

    /**
     * 数据处理
     *
     * @private
     * @memberof AppFileUploadDrag
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
     * @memberof AppFileUploadDrag
     */
    public created() {
        if (this.formState) {
            this.formStateEvent = this.formState.subscribe(($event: any) => {
                // 表单加载完成
                if (Object.is($event.type, 'load')) {
                    if (this.value) {
                        this.files = JSON.parse(this.value);
                    }
                    this.dataProcess();
                }
            });
        }
    }

    /**
     * vue 生命周期
     *
     * @returns
     * @memberof AppFileUploadDrag
     */
    public mounted() {
        this.appData = this.$store.getters.getAppData();

        let uploadparams: string = '';
        let exportparams: string = '';

        if (this.uploadparams && !Object.is(this.uploadparams, '')) {
            uploadparams = this.uploadparams;
        }
        if (this.exportparams && !Object.is(this.exportparams, '')) {
            exportparams = this.exportparams;
        }
        let upload_keys: Array<string> = uploadparams.split(';');
        let export_keys: Array<string> = exportparams.split(';');
        let custom_arr: Array<string> = [];
        if (this.customparams && !Object.is(this.customparams, '')) {
            Object.keys(this.customparams).forEach((name: string) => {
                custom_arr.push(`${name}=${this.customparams[name]}`);
            });
        }
        this.upload_keys = upload_keys;
        this.export_keys = export_keys;
        this.custom_arr = custom_arr;

        if (this.value) {
            this.files = JSON.parse(this.value);
        }
        this.dataProcess();
    }

    /**
     * 组件销毁
     *
     * @memberof AppFileUploadDrag
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
     * @memberof AppFileUploadDrag
     */
    public beforeUpload(file: any) {
        // console.log('上传之前');
    }

    /**
     * 上传成功回调
     *
     * @param {*} response
     * @param {*} file
     * @param {*} fileList
     * @memberof AppFileUploadDrag
     */
    public onSuccess(response: any, file: any, fileList: any) {
        if (!response) {
            return;
        }
        const data = { name: response.name, id: response.id };
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
     * @memberof AppFileUploadDrag
     */
    public onError(error: any, file: any, fileList: any) {
        this.$Notice.error({ title: '上传失败' });
    }

    /**
     * 删除文件
     *
     * @param {*} file
     * @param {*} fileList
     * @memberof AppFileUploadDrag
     */
    public onRemove(file: any, fileList: any) {
        let arr: Array<any> = [];
        fileList.forEach((f: any) => {
            if (f.id != file.id) {
                arr.push({ name: f.name, id: f.id });
            }
        });
        let value: any = arr.length > 0 ? JSON.stringify(arr) : null;
        this.$emit('formitemvaluechange', { name: this.name, value: value });
    }

    /**
     * 下载文件
     *
     * @param {*} file
     * @memberof AppFileUploadDrag
     */
    public onDownload(file: any) {
        window.open(file.url);
    }

}
</script>

<style lang='less'>
@import './app-file-upload-drag.less';
</style>