<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMVOCATIONALRedirectViewBase from './pimvocationalredirect-view-base.vue';


/**
 * 执（职）业资格信息数据重定向视图
 *
 * @export
 * @class PIMVOCATIONALRedirectView
 * @extends {PIMVOCATIONALRedirectViewBase}
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
export default class PIMVOCATIONALRedirectView extends PIMVOCATIONALRedirectViewBase { }
</script>