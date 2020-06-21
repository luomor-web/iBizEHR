/**
 * Main 部件模型
 *
 * @export
 * @class MainModel
 */
export default class MainModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof MainModel
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
        name: 'srfupdatedate',
        prop: 'updatedate',
        dataType: 'DATETIME',
      },
      {
        name: 'srforikey',
      },
      {
        name: 'srfkey',
        prop: 'trmteacherchargeid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'trmteacherchargename',
        dataType: 'TEXT',
      },
      {
        name: 'srftempmode',
      },
      {
        name: 'srfuf',
      },
      {
        name: 'srfdeid',
      },
      {
        name: 'srfsourcekey',
      },
      {
        name: 'trmtrainplantermname',
        prop: 'trmtrainplantermname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'trmtrainteachername',
        prop: 'trmtrainteachername',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'jsdj',
        prop: 'jsdj',
        dataType: 'SSCODELIST',
      },
      {
        name: 'dj',
        prop: 'dj',
        dataType: 'FLOAT',
      },
      {
        name: 'xs',
        prop: 'xs',
        dataType: 'FLOAT',
      },
      {
        name: 'zfy',
        prop: 'zfy',
        dataType: 'FLOAT',
      },
      {
        name: 'trmtrainteacherid',
        prop: 'trmtrainteacherid',
        dataType: 'PICKUP',
      },
      {
        name: 'trmteacherchargeid',
        prop: 'trmteacherchargeid',
        dataType: 'GUID',
      },
      {
        name: 'trmtrainplantermid',
        prop: 'trmtrainplantermid',
        dataType: 'PICKUP',
      },
      {
        name: 'trmteachercharge',
        prop: 'trmteacherchargeid',
        dataType: 'FONTKEY',
      },
    ]
  }

}