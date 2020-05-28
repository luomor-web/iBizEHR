<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMVOCATIONALCATALOGRedirectViewBase from './pimvocationalcatalogredirect-view-base.vue';


/**
 * 职（执）业资格目录管理数据重定向视图
 *
 * @export
 * @class PIMVOCATIONALCATALOGRedirectView
 * @extends {PIMVOCATIONALCATALOGRedirectViewBase}
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
export default class PIMVOCATIONALCATALOGRedirectView extends PIMVOCATIONALCATALOGRedirectViewBase { }
</script>