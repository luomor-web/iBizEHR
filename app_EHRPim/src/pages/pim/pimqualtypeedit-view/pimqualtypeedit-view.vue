<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMQUALTYPEEditViewBase from './pimqualtypeedit-view-base.vue';

import view_form from '@widgets/pim-qual-type/main-form/main-form.vue';

/**
 * 岗位（技能）证书编辑视图
 *
 * @export
 * @class PIMQUALTYPEEditView
 * @extends {PIMQUALTYPEEditViewBase}
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
export default class PIMQUALTYPEEditView extends PIMQUALTYPEEditViewBase { }
</script>