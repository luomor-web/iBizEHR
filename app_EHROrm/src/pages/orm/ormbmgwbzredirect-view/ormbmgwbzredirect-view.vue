<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMBMGWBZRedirectViewBase from './ormbmgwbzredirect-view-base.vue';


/**
 * 部门岗位编制数据重定向视图
 *
 * @export
 * @class ORMBMGWBZRedirectView
 * @extends {ORMBMGWBZRedirectViewBase}
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
export default class ORMBMGWBZRedirectView extends ORMBMGWBZRedirectViewBase { }
</script>