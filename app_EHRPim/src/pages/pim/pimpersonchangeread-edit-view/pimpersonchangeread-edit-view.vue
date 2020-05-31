<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMPERSONCHANGEReadEditViewBase from './pimpersonchangeread-edit-view-base.vue';

import view_form from '@widgets/pim-person-change/main-form/main-form.vue';

/**
 * 人员信息变更审核编辑视图
 *
 * @export
 * @class PIMPERSONCHANGEReadEditView
 * @extends {PIMPERSONCHANGEReadEditViewBase}
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
export default class PIMPERSONCHANGEReadEditView extends PIMPERSONCHANGEReadEditViewBase { }
</script>