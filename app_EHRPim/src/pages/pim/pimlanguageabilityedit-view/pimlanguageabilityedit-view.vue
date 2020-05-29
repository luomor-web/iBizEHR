<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMLANGUAGEABILITYEditViewBase from './pimlanguageabilityedit-view-base.vue';

import view_form from '@widgets/pim-language-ability/main-form/main-form.vue';

/**
 * 语言能力编辑视图
 *
 * @export
 * @class PIMLANGUAGEABILITYEditView
 * @extends {PIMLANGUAGEABILITYEditViewBase}
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
export default class PIMLANGUAGEABILITYEditView extends PIMLANGUAGEABILITYEditViewBase { }
</script>