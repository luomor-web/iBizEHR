<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMPERSONCHANGEEditViewBase from './pimpersonchangeedit-view-base.vue';

import view_form from '@widgets/pim-person-change/main-form/main-form.vue';

/**
 * 员工信息审核编辑视图
 *
 * @export
 * @class PIMPERSONCHANGEEditView
 * @extends {PIMPERSONCHANGEEditViewBase}
 */
@Component({
    components: {
        view_form, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class PIMPERSONCHANGEEditView extends PIMPERSONCHANGEEditViewBase { }
</script>