<template>
  <textarea :id="id"></textarea>
</template>
<script lang = 'ts'>
import { Vue, Component, Prop, Model, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { Environment } from '@/environments/environment';
import axios from 'axios';

import tinymce from "tinymce/tinymce";
import 'tinymce/themes/modern';
import 'tinymce/plugins/link';
import 'tinymce/plugins/paste';
import 'tinymce/plugins/table';
import 'tinymce/plugins/image';
import 'tinymce/plugins/imagetools';
import 'tinymce/plugins/codesample';
import 'tinymce/plugins/code';
import 'tinymce/plugins/fullscreen';
import 'tinymce/plugins/preview';

const tinymceCode:any = tinymce;



@Component({})
export default class AppRichTextEditor extends Vue {


    /**
     * 传入值
     */
    @Prop() value?: any;

    /**
     * 监听value值
     */
    @Watch('value', { immediate: true, deep: true })
    oncurrentContent(newval: any, val: any) {
        if (newval) {
            if(this.editor){
                tinymceCode.remove('#' + this.id);
            }
            this.init(newval);
        }
    }

    
    /**
     * 输入name
     */
    @Prop() name?: string;

    /**
     * 输入高度
     */
    @Prop() height?: any;

    /**
     * 是否禁用
     */
    @Prop() disabled?: any;

    /**
     * 当前语言,默认中文
     */
    public langu: any = localStorage.getItem('local') ? localStorage.getItem('local') : 'zh_CN' ;

    /**
     * 监听语言变化
     */
    @Watch('$i18n.locale')
    onLocaleChange(newval: any, val: any) {
      console.log("语言变更"+newval)
        this.langu = newval;
        if(this.editor){
            tinymceCode.remove('#' + this.id);
        }
        this.init('');
    }
    
    /**
     * 语言映射文件
     */
    public languMap:any = {
        'zh-CN': 'zh_CN',
        'en-US': 'en_US',
    };

    /**
     * 上传文件路径
     */
    public uploadUrl = Environment.BaseUrl + Environment.UploadFile;

    /**
     * 下载路径
     */
    public downloadUrl =  Environment.BaseUrl + Environment.ExportFile;

    /**
     * 当前富文本
     */
    public editor: any = null;

    /**
     *  当前富文本id
     */
    id: string = this.$util.createUUID();

    /**
     * 表单状态
     *
     * @type {Subject<any>}
     * @memberof AppRichTextEditor
     */
    @Prop() public formState?: Subject<any>;

    /**
     * 生命周期
     *
     * @memberof AppRichTextEditor
     */
    public created() {
        if(this.formState) {
            this.formState.subscribe(({ type, data }) => {
                if (Object.is('load', type)) {
                    if (!this.value) {
                        if(this.editor){
                            tinymceCode.remove('#' + this.id);
                        }
                        this.init(this.value);
                    }
                }
            });
        }
    }

    /**
     * 初始化富文本
     */
    public mounted() {
        this.init('');
    }
    
    /**
     * 销毁富文本
     */
    public destoryed(){
        tinymceCode.remove(this.editor);
    }

    /**
     * 初始化富文本
     * @param val 
     */
    public init(val: any) {
        let richtexteditor = this;
        tinymceCode.init({
            selector: '#' + this.id,
            width: 'calc( 100% - 2px )',
            height: this.height,
            min_height: 400,
            branding: false,
            plugins: ['link', 'paste', 'table', 'image', 'codesample', 'code', 'fullscreen', 'preview'],
            codesample_languages: [
                { text: 'HTML/XML', value: 'markup' },
                { text: 'JavaScript', value: 'javascript' },
                { text: 'CSS', value: 'css' },
                { text: 'PHP', value: 'php' },
                { text: 'Ruby', value: 'ruby' },
                { text: 'Python', value: 'python' },
                { text: 'Java', value: 'java' },
                { text: 'C', value: 'c' },
                { text: 'C#', value: 'csharp' },
                { text: 'C++', value: 'cpp' }
            ],
            paste_data_images: true,
            codesample_content_css: 'assets/tinymce/prism.css',
            skin_url: './assets/tinymce/skins/lightgray',
            language_url: './assets/tinymce/langs/' + this.languMap[this.langu] + '.js',
            language:this.languMap[this.langu],
            setup: (editor: any) => {
                this.editor = editor;
                editor.on('blur', () => {
                    const content = editor.getContent();
                    this.$emit('change', content);
                });
            },
            images_upload_handler: (bolbinfo: any, success: any, failure: any) => {
                const formData = new FormData();
                formData.append('file', bolbinfo.blob(), bolbinfo.filename());
                const _url = richtexteditor.uploadUrl;
                richtexteditor.uploadFile(_url, formData).subscribe((file: any) => {
                    if (file.filename) {
                        const id: string = file.fileid;
                        const url: string = `${richtexteditor.downloadUrl}/${id}`
                        success(url);
                    }
                }, (error: any) => {
                    console.log(error);
                    failure('HTTP Error: ' + error.status);
                });
            },
            init_instance_callback: (editor: any) => {
                this.editor = editor;
                let value = (this.value && this.value.length > 0) ? this.value : '';
                if (this.editor) {
                    this.editor.setContent(value);
                }
                if (this.disabled) {
                    this.editor.setMode('readonly');
                }
            }
        });
    }

    /**
     * 上传文件
     * @param url 
     * @param formData 
     */
    public uploadFile(url: string, formData: any) {
        let _this = this;
        const subject: Subject<any> = new Subject<any>();
        axios({
            method: 'post',
            url: url,
            data: formData,
            headers: { 'Content-Type': 'image/png', 'Accept': 'application/json' },
        }).then((response: any) => {
            if (response.status === 200) {
                subject.next(response.data);
            } else {
                subject.error(response);
            }
        }).catch((response: any) => {
            subject.error(response);
        });
        return subject;
    }
}
</script>
<style lang="less">
@import './app-rich-text-editor.less';
</style>