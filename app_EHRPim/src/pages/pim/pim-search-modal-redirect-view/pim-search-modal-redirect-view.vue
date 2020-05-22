<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PimSearchModalRedirectViewBase from './pim-search-modal-redirect-view-base.vue';


/**
 * 组合查询模版数据重定向视图
 *
 * @export
 * @class PimSearchModalRedirectView
 * @extends {PimSearchModalRedirectViewBase}
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
export default class PimSearchModalRedirectView extends PimSearchModalRedirectViewBase { }
</script>