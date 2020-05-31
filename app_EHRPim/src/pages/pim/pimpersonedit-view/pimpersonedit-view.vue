<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMPERSONEditViewBase from './pimpersonedit-view-base.vue';

import view_form from '@widgets/pim-person/ryinfo-form-form/ryinfo-form-form.vue';

/**
 * 人员首页编辑视图
 *
 * @export
 * @class PIMPERSONEditView
 * @extends {PIMPERSONEditViewBase}
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
export default class PIMPERSONEditView extends PIMPERSONEditViewBase { }
</script>