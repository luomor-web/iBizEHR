<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMXKMLEditViewBase from './pcmxkmledit-view-base.vue';

import view_form from '@widgets/pcm-xkml/main-form/main-form.vue';

/**
 * 学科目录编辑视图
 *
 * @export
 * @class PCMXKMLEditView
 * @extends {PCMXKMLEditViewBase}
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
export default class PCMXKMLEditView extends PCMXKMLEditViewBase { }
</script>