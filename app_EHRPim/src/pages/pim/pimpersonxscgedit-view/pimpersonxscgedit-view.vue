<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMPERSONXSCGEditViewBase from './pimpersonxscgedit-view-base.vue';

import view_form from '@widgets/pim-person/ryinfo-form-4-form/ryinfo-form-4-form.vue';

/**
 * 学术成果编辑视图
 *
 * @export
 * @class PIMPERSONXSCGEditView
 * @extends {PIMPERSONXSCGEditViewBase}
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
export default class PIMPERSONXSCGEditView extends PIMPERSONXSCGEditViewBase { }
</script>