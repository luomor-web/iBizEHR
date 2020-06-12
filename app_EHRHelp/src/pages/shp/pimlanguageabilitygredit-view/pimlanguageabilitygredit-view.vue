<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMLANGUAGEABILITYGREditViewBase from './pimlanguageabilitygredit-view-base.vue';

import view_form from '@widgets/pim-language-ability/main-2-form/main-2-form.vue';

/**
 * 语言能力编辑视图
 *
 * @export
 * @class PIMLANGUAGEABILITYGREditView
 * @extends {PIMLANGUAGEABILITYGREditViewBase}
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
export default class PIMLANGUAGEABILITYGREditView extends PIMLANGUAGEABILITYGREditViewBase { }
</script>