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
        prop: 'pimarchivesloanandreturnid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'pimarchivesloanandreturnname',
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
        name: 'jyr',
        prop: 'jyr',
        dataType: 'TEXT',
      },
      {
        name: 'jyqssj',
        prop: 'jyqssj',
        dataType: 'DATE',
      },
      {
        name: 'ghrq',
        prop: 'ghrq',
        dataType: 'DATE',
      },
      {
        name: 'jyyy',
        prop: 'jyyy',
        dataType: 'TEXT',
      },
      {
        name: 'spperson',
        prop: 'spperson',
        dataType: 'TEXT',
      },
      {
        name: 'spdate',
        prop: 'spdate',
        dataType: 'DATE',
      },
      {
        name: 'zt',
        prop: 'zt',
        dataType: 'SSCODELIST',
      },
      {
        name: 'pimarchivesid',
        prop: 'pimarchivesid',
        dataType: 'PICKUP',
      },
      {
        name: 'pimpersonid3',
        prop: 'pimpersonid3',
        dataType: 'PICKUP',
      },
      {
        name: 'pimarchivesloanandreturnid',
        prop: 'pimarchivesloanandreturnid',
        dataType: 'GUID',
      },
      {
        name: 'pimarchivesloanandreturn',
        prop: 'pimarchivesloanandreturnid',
        dataType: 'FONTKEY',
      },
    ]
  }

}