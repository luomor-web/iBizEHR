<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMLANGUAGEABILITYRedirectViewBase from './pimlanguageabilityredirect-view-base.vue';


/**
 * 语言能力数据重定向视图
 *
 * @export
 * @class PIMLANGUAGEABILITYRedirectView
 * @extends {PIMLANGUAGEABILITYRedirectViewBase}
 */
@Component({
    components: {
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class PIMLANGUAGEABILITYRedirectView extends PIMLANGUAGEABILITYRedirectViewBase { }
</script>