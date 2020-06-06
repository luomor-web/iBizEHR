<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PimSearchFieldSetRedirectViewBase from './pim-search-field-set-redirect-view-base.vue';


/**
 * 组合查询条件设置数据重定向视图
 *
 * @export
 * @class PimSearchFieldSetRedirectView
 * @extends {PimSearchFieldSetRedirectViewBase}
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
export default class PimSearchFieldSetRedirectView extends PimSearchFieldSetRedirectViewBase { }
</script>