<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMPERSONEditView2Base from './pimpersonedit-view2-base.vue';

import view_drbar from '@widgets/pim-person/ygcd-drbar/ygcd-drbar.vue';

/**
 * 员工首页编辑视图
 *
 * @export
 * @class PIMPERSONEditView2
 * @extends {PIMPERSONEditView2Base}
 */
@Component({
    components: {
        view_drbar, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class PIMPERSONEditView2 extends PIMPERSONEditView2Base { }
</script>