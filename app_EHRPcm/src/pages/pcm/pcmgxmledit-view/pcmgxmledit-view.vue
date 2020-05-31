<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMGXMLEditViewBase from './pcmgxmledit-view-base.vue';

import view_form from '@widgets/pcm-gxml/main-form/main-form.vue';

/**
 * 高校名录编辑视图
 *
 * @export
 * @class PCMGXMLEditView
 * @extends {PCMGXMLEditViewBase}
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
export default class PCMGXMLEditView extends PCMGXMLEditViewBase { }
</script>