<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMZPMEGLEditViewBase from './pcmzpmegledit-view-base.vue';

import view_form from '@widgets/pcm-zpmegl/main-form/main-form.vue';

/**
 * 招聘名额管理编辑视图
 *
 * @export
 * @class PCMZPMEGLEditView
 * @extends {PCMZPMEGLEditViewBase}
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
export default class PCMZPMEGLEditView extends PCMZPMEGLEditViewBase { }
</script>