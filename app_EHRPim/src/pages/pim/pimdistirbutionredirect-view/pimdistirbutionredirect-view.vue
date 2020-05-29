<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMDISTIRBUTIONRedirectViewBase from './pimdistirbutionredirect-view-base.vue';


/**
 * 分配信息数据重定向视图
 *
 * @export
 * @class PIMDISTIRBUTIONRedirectView
 * @extends {PIMDISTIRBUTIONRedirectViewBase}
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
export default class PIMDISTIRBUTIONRedirectView extends PIMDISTIRBUTIONRedirectViewBase { }
</script>