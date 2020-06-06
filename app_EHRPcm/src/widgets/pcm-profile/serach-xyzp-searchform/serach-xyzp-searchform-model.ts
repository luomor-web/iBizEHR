/**
 * Serach_XYZP 部件模型
 *
 * @export
 * @class Serach_XYZPModel
 */
export default class Serach_XYZPModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof Serach_XYZPModel
  */
  public getDataItems(): any[] {
    return [
      {
        name: 'srfwfmemo',
        prop: 'srfwfmemo',
        dataType: 'TEXT',
      },
      // 前端新增修改标识，新增为"0",修改为"1"或未设值
      {
        name: 'srffrontuf',
        prop: 'srffrontuf',
        dataType: 'TEXT',
      },
      {
        name: 'n_zzdzs_like',
        prop: 'zzdzs',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'n_pcmprofilename_like',
        prop: 'pcmprofilename',
        dataType: 'TEXT',
      },
      {
        name: 'n_certificatenumber_like',
        prop: 'certificatenumber',
        dataType: 'TEXT',
      },
      {
        name: 'n_gender_eq',
        prop: 'gender',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_yglx_eq',
        prop: 'yglx',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_r_lastschool_like',
        prop: 'r_lastschool',
        dataType: 'TEXT',
      },
      {
        name: 'n_xkml_eq',
        prop: 'xkml',
        dataType: 'SSCODELIST',
      },
    ]
  }

}