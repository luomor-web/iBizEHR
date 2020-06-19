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
        prop: 'trmtrainactmentid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'trmtrainactmentname',
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
        name: 'trmtrainactapplyid',
        prop: 'trmtrainactapplyid',
        dataType: 'PICKUP',
      },
      {
        name: 'evalcontents',
        prop: 'evalcontents',
        dataType: 'TEXT',
      },
      {
        name: 'evaltarget',
        prop: 'evaltarget',
        dataType: 'SSCODELIST',
      },
      {
        name: 'pxjg',
        prop: 'pxjg',
        dataType: 'SSCODELIST',
      },
      {
        name: 'evaltime',
        prop: 'evaltime',
        dataType: 'DATE',
      },
      {
        name: 'dcwjtm',
        prop: 'dcwjtm',
        dataType: 'TEXT',
      },
      {
        name: 'bz',
        prop: 'bz',
        dataType: 'LONGTEXT_1000',
      },
      {
        name: 'trmtrainactmentid',
        prop: 'trmtrainactmentid',
        dataType: 'GUID',
      },
      {
        name: 'trmtrainactment',
        prop: 'trmtrainactmentid',
        dataType: 'FONTKEY',
      },
    ]
  }

}